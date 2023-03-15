data class Comment(val id: Int, val body: String, val author: String)

fun printComments(commentsData: MutableList<Comment>){
    // write you code here
    //“Author: AUTHOR; Text: BODY"
    for((_,body,author) in commentsData){
        println("Author: $author; Text: $body")
    }
}

