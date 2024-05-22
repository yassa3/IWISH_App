# **i-Wish Project**

i-Wish is a desktop application designed to bring joy to users by enabling them to create wish lists, view friends' wish lists, and contribute to purchasing items for their friends. The application offers a user-friendly interface and several features to manage wish lists and friendships effectively.

## **Abstract**

i-Wish allows users to:

- Add and manage friends.
- Create, update, and delete personal wish lists.
- View friends' wish lists and contribute to the purchase of items.

The application also includes server-side functionalities for database management and client request handling.

## **Features**

### **Client**

1. **Register/Sign-in**
2. **Add/Remove Friend**
3. **Accept/Decline Friend Request**
4. **Create, Update, Delete Wish List**
5. **View Friends List**
6. **View Friends' Wish Lists**
7. **Contribute to Friends' Wish Lists**
    - Specify the amount of money towards an item's price.
8. **Notifications**
    - As a buyer: Receive a notification upon the completion of a gift item's price.
    - As a receiver: Receive a notification when an item from the wish list is bought by specific friends.
9. **User-Friendly GUI**
    - Ensure the interface is enjoyable and easy to use.

### **Server**

1. **Start/Stop Server**
2. **Database Management**
    - Connection and queries.
    - Adding items to the wish list database (via admin, database insertion, Amazon web service, other restful web services, or web crawling as a bonus).
3. **Client Connection Handling**
4. **Client Request Handling**

## **Installation and Setup**

1. **Clone the repository:**
    
    ```bash
    bashCopy code
    git clone https://github.com/yourusername/i-Wish.git
    cd i-Wish
    
    ```
    
2. **Open the project in NetBeans.**
3. **Setup the database:**
    - Import the database schema/backup provided in the delivery package.
4. **Run the server:**
    - Start the server to handle client connections and requests.
5. **Launch the client application:**
    - Register or sign in to start using i-Wish.
