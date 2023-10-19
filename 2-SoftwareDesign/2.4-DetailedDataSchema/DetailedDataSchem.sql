-- User Information table
CREATE TABLE UserInformation (
    ProfilePhoto VARCHAR(255) CHECK (LENGTH(ProfilePhoto) < 5000),
    Email VARCHAR(255) UNIQUE,
    Nickname VARCHAR(255) CHECK (LENGTH(Nickname) > 2)
);

-- User table
CREATE TABLE Users (
    UserID INT PRIMARY KEY,
    Login VARCHAR(20) CHECK (LENGTH(Login) < 20),
    Password VARCHAR(20) CHECK (LENGTH(Password) < 20),
    UserInformationID INT REFERENCES UserInformation
);

-- Choreographer table
CREATE TABLE Choreographer (
    ChoreographerID INT PRIMARY KEY,
    Specialization VARCHAR(255) CHECK (LENGTH(Specialization) > 5),
    Experience VARCHAR(255),
    UserInformationID INT REFERENCES UserInformation
);

-- Create Post table
CREATE TABLE CreatePost (
    PostID INT PRIMARY KEY,
    Text VARCHAR(500),
    File VARCHAR(255) CHECK (LENGTH(File) < 100000),
    UserID INT REFERENCES Users
);

-- Comment table
CREATE TABLE Comment (
    CommentID INT PRIMARY KEY,
    Response VARCHAR(300),
    Date DATE CHECK (Date >= CURRENT_DATE),
    UserID INT REFERENCES Users
);

-- Temperature Control table
CREATE TABLE TemperatureControl (
    ControlID INT PRIMARY KEY,
    AirPurifier BOOLEAN,
    Mode VARCHAR(255) CHECK (LENGTH(Mode) < 5),
    Temperature INT CHECK (Temperature BETWEEN 15 AND 30),
    AutomaticSetting BOOLEAN
);
