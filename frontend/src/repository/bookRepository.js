import axios from '../custom-axios/axios'

const BookService = {
    fetchBooks: () => {
        return axios.get("/books")
    },
    fetchCategories: () => {
        return axios.get("/categories")
    },
    fetchAuthors: () => {
        return axios.get("/authors")
    },
    deleteBook: (id) => {
        return axios.delete(`/books/delete/${id}`)
    },
    addBook: (name, author, category, availableCopies) => {
        return axios.post("/books/add", {
            "name" : name,
            "authorId" : author,
            "category" : category,
            "availableCopies" : availableCopies
        })
    },
    editBook: (id, name, author, category ,availableCopies) => {
        return axios.put(`/books/edit/${id}`, {
            "name" : name,
            "authorId" : author,
            "category" : category,
            "availableCopies" : availableCopies
        })
    },

    getBook: (id) => {
        return axios.get(`/books/get/${id}`)
    },
    markBookAsTaken: (id) => {
        return axios.put(`/books/mark/${id}`);
    }
}

export default BookService;