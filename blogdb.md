USERS
- id (int, primary key)
- username (varchar)
- email (varchar)
- password (varchar)

POSTS
- id (int, primary key)
- user_id (int, foreign key to USERS.id)
- title (varchar)
- body (text)
- created_at (timestamp)
- updated_at (timestamp)

COMMENTS
- id (int, primary key)
- user_id (int, foreign key to USERS.id)
- post_id (int, foreign key to POSTS.id)
- body (text)
- created_at (timestamp)
- updated_at (timestamp)
  This schema has three tables: USERS, POSTS, and COMMENTS.
