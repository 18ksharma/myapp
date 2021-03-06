Original App Design Project - README Template
===

# AirBNB for Bikes

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
2. [Schema](#Schema)

## Overview
### Description
#### Airbnb for bikes & scooters:
- **Description:** Bike owners and scooter owners can put their bike/scooter up for sale and users can rent the bike/scooter from them

#### Student Matching App:
- **Description**: Connects incoming college freshmen to other incoming freshmen in their area so that students can get to know each other before they begin college


### App Evaluation
[Evaluation of your app across the following attributes]

#### Airbnb for bikes & scooters:
- **Category**: Lifestyle
- **Mobile**: Users are able to browse available bikes and scooters in close proximity to them, organizing the layout by location, price, seller reputation
- **Story**: Connects people who need eco friendly transportation to people who are willing to rent theirs
- **Market**: The market for this would be very large, as a lot of people use bikes and scooters on the daily, especially on large college campuses.
- **Habit:** This app is not necessarily addictive, but rather the need for transportation and the addictiveness of biking will cause users to use this app. Users can save money by avoiding to purchase a bike or scooter. Bike owners will use this to make more money off of their bike or scooter
- **Scope**: V1 would allow bike owners and bike seekers to make a profile. V2 would allow bike seekers to view bike owners bikes in the area. V3 would incorporate some third party messaging tool (opens email). V4 would incorporate an internal messaging tool



## Product Spec

### 1. User Stories (Required and Optional)

**Required Must-have Stories**

* [X] Bottom navigation (multiple views)
* [X] Uses Parse (database)
* [X] User can create a new account
    * User can take a picture or choose an image from their galleryand set it as their profile picture
    * User has to confirm password upon creating account
* [X] User can login
    * [X] User is still logged in when they close app / turn off phone
* [X] User can see a stream of bikes where bike posts are ordered by relative distance from current user
* [X] User can create a post for putting a bike for rent with bike price, description, availability, condition, location, upload bike pic from camera or photo gallery
* [X] User can logout
* [X] User can see their own posts on the profile Fragment
* [X] User can click on a post to see more details
* [X] In detailed view, users can contact the bike owner where contact button opens email app with subject filled in and owner's email
* [X] Integrates GoogleMaps SDK to display bike location in detailed view
* [X] User can search specific bike descriptions using search Fragment (complex algo)
* [X] User can click on a post to see a detail view)
* [X] User can zoom in on bike images in PostDetails (Gesture feature)


**Optional Nice-to-have Stories**

* [X] ProfileFragment shows posts in grid format
    * [X] User can click on post for detailed view
* [X] Refresh Feature on home feed
* [X] Infinite scroll on home feed
* [X] User can delete their post with popup that confirms if they want to delete post
* [X] Use spinner for displaying condition of the bike
* [X] Settings page where user can change their username and profile picture
* [X] User can delete their account with popup that confirms if they want to delete account
* [X] User can edit a post that they have made
* [X] Relative distance from user to a post
* [X] Adding comments to posts
* [X] Forget password button Sends user an email
* [X] Filter search by Condition, Price, Description, or Availability
* [X] Delete comments
* [X] User can shake phone to clear fields in ComposeFragment (gesture feature)
* [X] User can expand and collapse recyclerview that displays comments (animation)
* [X] Animation with dropping google maps marker in postdetails map fragment (animation)
* [X] Animation with zooming in on marker in postdetails map fragment (animation)
* [X] Will not let user sign up if they are missing username field, email field, password field, or confirm password
* [X] Will not let user post if they are missing required attributes in their post.
* [X] Uses places API for user to search for location in compose fragment if the bike is located elsewhere
* [X] Created logo that is shown in actionbar
* Open venmo app to complete transaction
* Internal Messaging Tool
* Users can add ratings for people who have posts
* Implement Likes on a specific bike
* Add rating to other users
* Show posts only a certain distance away (filtering)
* display location of bike in a range bubble (like airbnb)
* Press and hold to delete posts on the profilefragment

### 2. Screen Archetypes

* Initial screen
   * Asks user to log in or sign up (two separate buttons)
* Login
   * User can log in
* Register
   * User can register & create an account
* Stream
    * User can see available bikes in their area
    * Filter search
    * Search for posts
* Compose
    * User can create a post for putting a bike for rent (bike price, details, availability, contact information, upload bike pic)
* Detail View
    * User can see bike details, bike picture, and bike location (from GoogleMaps API), and has a button in which user can click to contact owner
* Profile View
    * User can logout
* Setting page


### 3. Navigation

**Tab Navigation** (Tab to Screen)

* Bottom Navigation
    * Home View
    * Compose View
    * Profile View

**Flow Navigation** (Screen to Screen)

* Initial Screen
   * Login
   * Register
* Login
   * Stream
* Register
    * Stream
* Stream
    * None
* Compose
    * Stream
* Profile
    * Settings
    * Initial page
* Settings
    * Initial page
    * Stream
* Detail view
    * Edit
    * Stream
* Edit
    * Stream


## Wireframes
[Add picture of your hand sketched wireframes in this section]
![](https://i.imgur.com/GSCiGBn.png)


### [BONUS] Digital Wireframes & Mockups
https://www.figma.com/file/06wK69DFoCKtWoQrf5ChPn/Cycleshare?node-id=0%3A1

### [BONUS] Interactive Prototype
https://www.figma.com/proto/06wK69DFoCKtWoQrf5ChPn/Cycleshare?node-id=1%3A2&scaling=min-zoom

## Schema
### Models

Bike Post

| Property | Type     | Description |
| -------- | -------- | -------- |
| objectId| String| unique id for user post|
|author | pointer to user|tells who created the post|
|image |file | picture of the bike|
|createdAt|DateTime|date when post is created (default field)|
|updatedAt|DateTime|date when post is updated (default field)|
|Location|String|Location of the bike|
|Price|Number|price of the bike|
|Description|String|Details about the bike|

User
| Property  | Type     | Description |
| --------  | -------- | -------- |
| objectId| String| unique id for user post|
| email     | String     | email unique to a user     |
|profilePicture| File| Profile picture unique to user|
|password|String|password for login|
|createdAt|DateTime|date when post is created (default field)|
|updatedAt|DateTime|date when post is updated (default field)|

Comment
| objectId| String| unique id for user post|
|author | pointer to user|tells who created the comment|
|post |pointer to the post | tells post on which comment was placed|
| createdAt| Date| tells when the comment was created|

### Networking

[Add list of network requests by screen ]
- Login
    - (Read/CHECK) if user credientials are authorized
- Signup
    - (Create) new User with user credentials
- Home
    - (Read/GET) all posts

> [let query = PFQuery(className:"Post")
    query.order(byDescending: "createdAt")
    query.findObjectsInBackground { (posts: [PFObject]?, error: Error?) in
    if let error = error {
        print(error.localizedDescription)
    }
    else if let posts = posts {
        print("Successfully retrieved \(posts.count) posts.")
        //display posts in recycler view
    }
    }]
- Create Post Screen
    - (Create/POST) Create a new post object
- Detail View
    - (Create) User can email other users
- Search
    - (Read/Get) Search for entries based on location (Complex Algo)
> [let query = PFQuery(className:"Post")
    query.whereKey("location", equalTo: current location) //obtained through API
    query.order(byDescending: "createdAt")
    query.findObjectsInBackground { (posts: [PFObject]?, error: Error?) in
    if let error = error {
        print(error.localizedDescription)
    }
    else if let posts = posts {
        print("Successfully retrieved \(posts.count) posts.")
        //display search resultsby location
   }
}]


[OPTIONAL: List endpoints if using existing API such as Yelp]
- Google Maps API Base URL https://www.google.com/maps/@?api=1&map_action=map[api_key] (displaying a map)
    -
- Google Maps API Base URL https://www.google.com/maps/search/?api=1[api_key]
