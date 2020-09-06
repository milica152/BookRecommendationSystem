import React, {Fragment, useState} from 'react';
import SearchBar from "../components/SearchBar";
import BooksListView from "../components/BooksListView";

const BooksPage = () => {
    const [searchParameter, setSearchParameter] = useState(null);   //if null, look for the content constant
    const [booksContent, setBooksContent] = useState(null);     // if null, look for the searchParameter constant

    const handleOnChangeSearchParameter = (newSearchParameter) => setSearchParameter(newSearchParameter);
    const handleOnChangeRecommendationContent = (recommendationContent) => {
        setBooksContent(recommendationContent);
        console.log('changed');
    };

    return <Fragment>
            <SearchBar onSearch = {handleOnChangeSearchParameter} onGetRecommendation={handleOnChangeRecommendationContent}/>
            <BooksListView searchParameter = {searchParameter} content = {booksContent}/>
        </Fragment>
};

export default BooksPage;
