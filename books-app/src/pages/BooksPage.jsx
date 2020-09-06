import React, {Fragment, useState, useEffect} from 'react';
import SearchBar from "../components/SearchBar";
import BooksListView from "../components/BooksListView";
import booksService from "../services/booksService";

const BooksPage = () => {
    const [booksContent, setBooksContent] = useState([]);
    const handleOnChangeContent = (content) => setBooksContent(content);

    useEffect(() => booksService.getAll("").then(response => handleOnChangeContent(response)), []);
    console.log(booksContent);

    return <Fragment>
            <SearchBar onchangecontent = {handleOnChangeContent}/>
            <BooksListView content = {booksContent}/>
        </Fragment>
};

export default BooksPage;
