package com.project.demo.service;

import com.project.demo.dto.PersonInfoDTO;
import com.project.demo.model.Book;
import com.project.demo.model.Genre;
import com.project.demo.model.GenreScore;
import com.project.demo.model.GenreWrapper;
import com.project.demo.repository.BookRepository;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public List<Book> getTopTen(PersonInfoDTO personInfoDTO) {
        // TODO --- forward chaining treci nivo dodas da zakljucuje preference na osnovu ageGroup,
        //  dakle ukoliko u listi sfera interesovanja nema ta odredjena za dati uzrast i ukoliko je uzrast dati
        //  dodaj tu preferencu u listu interesovanja i onda ce se okinuti jos jedan prolaz pravila (treci krug
        //  chaining-a)

        // TODO - mozda preko accumulate da uradim knjige koje je korisnik procitao, kao from accumulate Book
        //  (necemo ubaciti ovaj put genre) pa izbrojis koji zanr preovladava u listi (neki checkboxevi ali u
        //  ogranicenom prostoru), taj zanr povecaj za 2

        // TODO - ako stignem, uraditi validaciju preko pravila, mozda da kada se naidje na nesto sto je
        //  pogresno da se automatski izbaci GenreScores iz radne memorije i mozda ubaci poruka o gresci
        //  (baca hendlovanu gresku??)

        // TODO - mozda spajati vise spheresOfInterests kao u predef. projektu pa da se spojene ponasaj drugacije

        // TODO - uzeti onda u obzir i ageOfBook zajedno sa ageGroup,
        //  takodje uzeti u obzir i ocenu knjiga --- OBAVEZNO FORWARD CHAINING NA 3 NIVOA, to je uslov za polaganje

        HashMap<Genre, Integer> innerMap = new HashMap<>();
        innerMap.put(Genre.ROMANCE, 0);
        innerMap.put(Genre.CHILDREN, 0);
        innerMap.put(Genre.EDUCATION, 0);
        innerMap.put(Genre.CRIME, 0);
        innerMap.put(Genre.DRAMA, 0);
        innerMap.put(Genre.SCI_FI, 0);
        innerMap.put(Genre.BIOGRAPHY, 0);
        innerMap.put(Genre.COMEDY, 0);
        innerMap.put(Genre.COOKING, 0);
        innerMap.put(Genre.HISTORY, 0);
        innerMap.put(Genre.MUSIC, 0);
        innerMap.put(Genre.SPORT, 0);
        innerMap.put(Genre.CLASSIC, 0);
        GenreScore genreScores = new GenreScore(innerMap);

        KieServices ks = KieServices.Factory.get();
        KieContainer kieContainer = ks.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("ksession-rules");

        FactHandle handle0 = kieSession.insert(personInfoDTO);
        FactHandle handle1 = kieSession.insert(genreScores);

        kieSession.fireAllRules();

        kieSession.delete(handle1);
        kieSession.delete(handle0);   // in order to start again

        genreScores.setGenreScores(sortByValue(genreScores.getGenreScores()));
        System.out.println(genreScores.getGenreScores());
        List<Genre> genres = new ArrayList<Genre>(genreScores.getGenreScores().keySet());
        System.out.println(genres);

        GenreWrapper desiredGenre = new GenreWrapper(genres.get(genres.size()-1));
        List<Book> result = findByGenre(desiredGenre, kieSession);
        kieSession.dispose();

        return result;
    }

    public Double getAdviseForBook(String id) {
        return 0.0;
    }

    public List<Book> getBooks(String searchParam) {
        return bookRepository.findAllByNameContaining(searchParam);
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public void removeBook(Book book) {
        bookRepository.delete(book);
    }

    private HashMap<Genre, Integer> sortByValue(HashMap<Genre, Integer> hm) {
        // Create a list from elements of HashMap
        List<Map.Entry<Genre, Integer> > list =
                new LinkedList<Map.Entry<Genre, Integer> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Genre, Integer> >() {
            public int compare(Map.Entry<Genre, Integer> o1,
                               Map.Entry<Genre, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<Genre, Integer> temp = new LinkedHashMap<Genre, Integer>();
        for (Map.Entry<Genre, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    public List<Book> findByGenreString(String genre){
        KieServices ks = KieServices.Factory.get();
        KieContainer kieContainer = ks.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("ksession-rules");
        GenreWrapper genreWrapper = new GenreWrapper(Genre.valueOf(genre));
        List<Book> result = findByGenre(genreWrapper, kieSession);
        kieSession.dispose();
        return result;
    }

    private List<Book> findByGenre(GenreWrapper desiredGenre,  KieSession kieSession) {
        System.out.println(desiredGenre.getGenre());

        kieSession.insert(desiredGenre);
        List<Book> allBooks = bookRepository.findAllByNameContaining("");
        for(Book b : allBooks){
            kieSession.insert(b);
        }
        kieSession.fireAllRules();

        Collection<?> objects = kieSession.getObjects();
        List<Book> result = new ArrayList<>();
        for(Object o : objects){
            if(o instanceof Book){
                result.add((Book)o);
            }
        }

        return result;
    }

}
