import React, {useState, useEffect} from 'react';
import booksService from "../services/booksService";
import BooksListItem from "./BooksListItem";

const ClientListView = (props) => {
    const [items, setItems] = useState([]);
    //const updateBooks = () => booksService.getAll(props.searchParameter).then(async (data) => await setItems(data));
    const Books = () => items.map(item => <BooksListItem key={item.id} book={item} />);
// probaj bez useeffect
        //updateBooks();
        console.log('ioks');
        if(props.searchParameter!==null){
            console.log('searching');
            console.log(props.searchParameter);
        } else if(props.content!== null){
            console.log('getting recommendation');
            console.log(props.content);
        }

    return (
        <React.Fragment>
            <div className="accordion-wrap clients">
                <h3>Books</h3>
                <Books/>
                <BooksListItem book={{name: "name", published:"ok"}}/>
            </div>
        </React.Fragment>
    );
};

export default ClientListView;
