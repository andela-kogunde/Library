# Checkpoint One (Library)

>Research reveals that most people visit fun environment such as cinemas, libraries, amusement park e.t.c because of its organized fun activities.

>Imagine how muddled an amusement park or a football club would be if it's not organized. 
#####
The subsequent paragraphs explains the process of real life Book Library senario where Staff has priority over Students.

0.  Requester requests for book.
1.  Before a book is lend out.
2.  Library Manager verifies that requester (Staff or Student) is a member of Book Library Club, else no book is lend out.
3.  If requester is a member then Library Manager checks if the requested book is available.
4.  If true then the book is lend out based on set priority.

>This process can be hectic having large number of requesters' concurrently.
#

  __Library__  is a java package developed to simplify a tedious organized process. It is packaged with an ItemQueue class to handle prioritization.
It also has the capacity to manage and organize large number of requesters' concurrently. 

  __Library__   Package is easy to setup and requires no extra plug-in.

# Library
UML Class Diagram

![Alt text](https://github.com/andela-kogunde/Library/blob/ft-test-to-fail-and-pass-application-logic-110294434/diagram.png?raw=true "Library UML Class Diagram")


#

# Features
### Manage member of an organization. 

* Abstract Member (class) : Has a particular ability to manage member information e.g. (id, name);

### Manage items (Books, Golf Cart etc) of an organization. 

* Abstract Item (Class): Has the ability to manages items own by an organization e.g. (Book for Library, Jersey for Football club).

### Prioritize members.

* ItemQueue (Class) : Has the capicity to prioritize member e.g. (Staff over Student of a Library, Coach over players of a Football team).

#
### Examples and Usage (Creating a simple Book Library).

>Extending a Member Class
#

```Java
public class Student extends Member {
	
	public Student(String fullName) {
        super(fullName);
    }

    @Override
    public int compareTo(Member o) {
        return 0;
    }
}

public class Staff extends Member {
	
	public Staff(String fullName) {
        super(fullName);
    }

    @Override
    public int compareTo(Member o) {
        return 0;
    }
}

Student student = new Student("John Doe");
Staff staff = new Staff("Jane Doe");
```

#
#
>Extending an Item Class
#

```Java
public class Book extends Item {

    private String title;

    public Book(String title, int totalCopies) {
        super(totalCopies);
        this.title = title;
    }

}

Book book = new Book("JAVA PROGRAMMING", 4);
```

#
#

>Extending an ItemQueue class
#

```Java
public class BookQueue extends ItemQueue<Book, Member> {

    public BookQueue() {
        super();
    }

}
```

#
#

>Extending an Organization class
#

```Java
public class Library extends Organization<Book, Member> {

    BookQueue bookQueue;
    
    public Library() {
        super();
        bookQueue = new BookQueue();
    }

}

Library library = new Library();
```

#
#
### Checkpoint one (Library) 
>  __Library__  package has a Book Library Class packaged with it.
#

```Java
Library library = new Library();
```
#

>Add members to Library.
#

```Java
library.addMember(staff);
library.addMember(student);
```
#

>Add a book to Library.
#

```Java
library.addItem(book);
```
#

>Add a book request.
#

```Java
library.addBookRequest(book, student);
```
#

>Get number of book borrowed
#
```Java
library.sizeOfBorrowedBooks()
```
#
>Get members queue who borrowed a book
#
```Java
PriorityQueue<Member> members = library.getBorrowedBook(book);
```
#
>Using the member queue
#
```Java
while (book.getTotalItem() > 0 && members.poll() != null) {
    book.setTotalItem(book.getTotalItem() - 1);
}
```
#
>Another Method: Using the member queue
#

```Java

Iterator<Member> iterator = library.borrowedBookIterator(book2);
	while (iterator.hasNext()) {
            Member member = iterator.next();
        }
```
#
>MORE HELPFUL METHODS.
#
```Java
library.addMember(student); //ADD SINGLE MEMBER
library.addAllMembers(memberList); //ADD COLLECTION OF MEMBER
library.addItem(book); //ADD SINGLE ITEM
library.addAllItems(bookList); //ADD COLLECTION OF ITEM E.G. BOOKS
library.isBorrowedBookEmpty(); //CHECKS IF BOOKQUEUE IS EMPTY
library.borrowedBookContains(book); //CHECKS IF BOOKQUEUE CONTAINS BOOK
library.borrowedBookIterator(book); //RETURNS AN ITERATOR FOR BOOKQUEUE
library.removeBorrowedBook(book); //REMOVES A BOOKQUEUE FROM THE LIST OF BOOK REQUESTED
--
library.clearBookRequest();
```
#
### Get Checkpoint One (Library)
#
```
Local Checkout 
git clone https://github.com/andela-kogunde/Library.git
```
#
### Projects using Checkpoint One (Library)
There are few numbers of apps that uses __"Checkpoint One (Library)"__. Feel free to contact me or submit a pull request to add yours to this list.

* Book Library


### Development

Want to contribute? Great!

1.  Fork [__Library__](https://github.com/andela-kogunde/Library.git) repository.
2.  Make the fix.
3.  Submit a pull request.

### Todos

 - Add more organizations such as (Football Club, Golf Club)
 - Add more Item such as (Jerseys, Golf Carts)

License
----

MIT


**Free Software!**
#
#
