import React from 'react';
import BooksListItem from "./BooksListItem";

const BooksListView = (props) => {
    const Books = () => props.content.map(item => <BooksListItem key={item.id} book={item} />);

    return (
        <React.Fragment>
            <div className="accordion-wrap clients">
                <h3>Books</h3>
                <Books/>
            </div>
        </React.Fragment>
    );
};

export default BooksListView;
