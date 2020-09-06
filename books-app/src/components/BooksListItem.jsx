import React, {useState} from 'react';

const BooksListItem = (props) => {
    const [book, setBook] = useState(props.book);

    const Book = () => <div className="heading" align="left">
        <span >{book.name}, {book.published}</span>
    </div>;

    return <div className="item">
        <Book/>
    </div>
};

export default BooksListItem;
