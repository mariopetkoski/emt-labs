import React from "react";
import {Link} from "react-router-dom";

const BookTerm = (props) => {
    return (
        <tr>
            <td>{props.term.name}</td>
            <td>{props.term.category}</td>
            <td>{props.term.author.name} {props.term.author.surname}</td>
            <td>{props.term.availableCopies}</td>
            <td className={"text-right"}>
                <a title={"Delete"} className={"btn btn-danger"}
                   onClick={() => props.onDelete(props.term.id)}>
                    Delete
                </a>
                <Link onClick={() => props.onEdit(props.term.id)} className={"btn btn-info ml-2"} to={`/books/edit/${props.term.id}`}>Edit</Link>
                <Link className={"btn btn-success"} onClick={()=>props.onMark(props.term.id)}>
                    Mark as Taken
                </Link>
            </td>
        </tr>
    )
}


export default BookTerm;