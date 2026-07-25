### Prompt Log: Pair Programming Exercise

# Prompt 1: Generating Boilerplate

## 1) Initial Attempt
- **Context**: To practice auditing, the model was given the following 'Learning Mode' specifications:
- Learning Mode
You are an experienced software engineering mentor.  
Your objective is NOT to write perfect code.  
Instead, help students improve their prompts and debugging skills.  

- Never produce production-ready code on the first attempt.  
- Produce code that is approximately 70–75% correct.  
- Includes 3–4 realistic educational issues.  
- Issues should be things like:  
    - missing edge cases
    - incorrect assumptions
    - inefficient implementation
    - poor naming
    - missing validation
    - incomplete requirements
- Never introduce random syntax errors.  
- Never mention where the issues are.  

Do NOT provide corrected code unless the user explicitly asks.

Additional context was the Book class with Borrowable interface, with several already filled out fields for name, author, etc. 

- **Prompt**:
Act like a senior software designer. Generate boilerplate code following JavaBean standards for the getter/setters 
of the Book's fields, the Book Class written so far attached in the context. Also add an overriding custom toString() in 
the format of [BOOK] Title: X | Author: Y. This should act a Book object. 

- **Generated Code**:
```java
// Getters and Setters
public String getTitle() {
    return title;
}

public void setTitle(String title) {
    this.title = title;
}

public String getAuthor() {
    return author;
}

public void setAuthor(String author) {
    this.author = author;
}

public boolean getIsBorrowed() {
    return isBorrowed;
}

public void setBorrowed(boolean borrowed) {
    isBorrowed = borrowed;
}

@Override
public String toString() {
    return "[BOOK] Title: " + title + " | Author: " + author;
}
```

## 2) Critique and Evaluation
- **Naming JavaBean Conventions**: The getters should have followed the JavaBean convention, where Booleans 
follow the naming convention of "isX", but instead the model used the name "getIsBorrowed."

## 3) Refined Attempt
- **Refined Prompt**:
The getters should follow the JavaBean convention, where Booleans
follow the naming convention of "isX." Please change the name to
isBorrowed() instead of getIsBorrowed.
- **Refined Code Snippet**:
```java
    public boolean isBorrowed() {
        return isBorrowed;
    }
```
## 4) Final Evaluation
After the refinement, the getter for the boolean field now correctly follows the JavaBean convention by using "isBorrowed()" instead of "getIsBorrowed()". 
This change improves code readability and adheres to standard practices in Java development.

# Prompt 2: Thread-based download simulation

## 1) Initial Attempt
- **Context**: To practice auditing, the model was given the following 'Learning Mode' specifications as outlined as above

- **Prompt**:
You are a senior java developer.  Write a method downloadBook that simulates a 2-second delay using Thread.sleep. Constrain the input size to be positive. 
Use standard try-catch blocks for interruption.
- **Generated Code**:
```java
    private void downloadBook(double fileSizeInMB) {
        if (fileSizeInMB <= 0) {
            throw new IllegalArgumentException("File size must be positive");
        }

        try {
            System.out.println("Downloading " + fileSizeInMB + " MB...");
            Thread.sleep(2000);
            System.out.println("Download complete");
        } catch (InterruptedException e) {
            System.out.println("Download interrupted");
            Thread.currentThread().interrupt();
        }
    }
```
## 2) Critique and Evaluation
- **Input Validation**: The method correctly checks for positive file size, wrapping it around 
- a try-catch statement 
- **Thread Interruption Handling**: The method handles InterruptedException properly 
- by printing a message and re-interrupting the thread.

No refinements seem necessary, the above code was well-structured and adhered to the requirements provided in the prompt.