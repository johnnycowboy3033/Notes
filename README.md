# Notes

## References

[Full Stack ReactJS with Spring Boot](https://www.youtube.com/watch?v=-LUA-LHXobE)


**Terminate the Application in Eclipse:**

 Open Eclipse and go to the Console view.

 Look for the Spring Boot application that's running.

 Click the Terminate button (red square) on the top right corner of the Console view.

**Identify and Kill the Process Manually:**

 If the application didn't stop, you can identify the process using the port.

 On Windows: Open Command Prompt and run:

SH
```
netstat -ano | findstr <Port Number>
```

Replace <Port Number> with the port number your Spring Boot application is using (e.g., 8080).

This will show you the process ID (PID) using that port.

Then, run:

SH
```
taskkill /F /PID <PID>
```
Replace <PID> with the actual process ID.

**Change the Port in Your Spring Boot Application:**

To avoid port conflicts in the future, you can change the port your Spring Boot application uses.

Open the application.properties or application.yml file in your project.

Add or modify the following line:

properties
```
server.port=8081
```

Save the file and restart your application.

import com.fasterxml.jackson.databind.ObjectMapper;

public class JavaToJsonExample {
    public static void main(String[] args) {
        // Create a sample object
        Person person = new Person("John", "Doe", 30);

        // Create an ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Convert the Java object to a JSON string
            String jsonString = objectMapper.writeValueAsString(person);

            // Print the JSON string
            System.out.println("JSON Output: " + jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Sample class to convert
class Person {
    private String firstName;
    private String lastName;
    private int age;

    // Constructor
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    // Getters and setters (required for serialization)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}


Here's a basic example of HTML and JavaScript code that reads a JSON object and displays its contents in a table:

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Display JSON in Table</title>
  <style>
    table {
      width: 50%;
      border-collapse: collapse;
      margin: 20px 0;
    }
    th, td {
      border: 1px solid #ddd;
      padding: 8px;
      text-align: left;
    }
    th {
      background-color: #f2f2f2;
    }
  </style>
</head>
<body>
  <h1>JSON to Table</h1>
  <table id="dataTable">
    <thead>
      <tr>
        <th>Name</th>
        <th>Age</th>
        <th>City</th>
      </tr>
    </thead>
    <tbody>
      <!-- Rows will be generated here by JavaScript -->
    </tbody>
  </table>

  <script>
    // Example JSON data
    const jsonData = [
      { "name": "Alice", "age": 25, "city": "New York" },
      { "name": "Bob", "age": 30, "city": "San Francisco" },
      { "name": "Charlie", "age": 35, "city": "Chicago" }
    ];

    // Reference the table body
    const tableBody = document.querySelector('#dataTable tbody');

    // Populate the table with JSON data
    jsonData.forEach(item => {
      const row = document.createElement('tr');
      row.innerHTML = `
        <td>${item.name}</td>
        <td>${item.age}</td>
        <td>${item.city}</td>
      `;
      tableBody.appendChild(row);
    });
  </script>
</body>
</html>
```

### How it works:
1. The JSON data is defined in the `jsonData` array in JavaScript.
2. The script dynamically creates table rows and cells based on the JSON data.
3. It then appends these rows to the table body (`<tbody>`).

You can copy this code, save it to an `.html` file, and open it in your browser to see the table dynamically populated with JSON data! Let me know if you'd like to add any specific features to this

```

import React from 'react';
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';

function Home() {
  return <h2>Home Page</h2>;
}

function About() {
  return <h2>About Page</h2>;
}

function Contact() {
  return <h2>Contact Page</h2>;
}

function NavBar() {
  return (
    <nav style={{ display: 'flex', gap: '15px' }}>
      <Link to="/">Home</Link>
      <Link to="/about">About</Link>
      <Link to="/contact">Contact</Link>
    </nav>
  );
}

export default function App() {
  return (
    <Router>
      <div>
        <NavBar />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/about" element={<About />} />
          <Route path="/contact" element={<Contact />} />
        </Routes>
      </div>
    </Router>
  );
}

```

```
function App() {
  const items = [];
  for (let i = 1; i <= 5; i++) {
    items.push(<li key={i}>Item {i}</li>);
  }

  return (
    <div>
      <h1>My List:</h1>
      <ul>{items}</ul>
    </div>
  );
}

export default App;

```

```
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService; // Assume this service handles user-related logic

    // Endpoint to handle the POST request
    @PostMapping
    public ResponseEntity<String> saveUser(@Valid @RequestBody User user) {
        try {
            userService.saveUser(user); // Saving user to the database
            return new ResponseEntity<>("User saved successfully!", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error saving user: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

````

```
import React from 'react';
import { Navbar, Nav, NavDropdown } from 'react-bootstrap';

const NavigationBar = () => {
  return (
    <Navbar bg="dark" variant="dark" expand="lg">
      <Navbar.Brand href="#home">MyApp</Navbar.Brand>
      <Navbar.Toggle aria-controls="basic-navbar-nav" />
      <Navbar.Collapse id="basic-navbar-nav">
        <Nav className="me-auto">
          <Nav.Link href="#home">Home</Nav.Link>
          <Nav.Link href="#about">About</Nav.Link>
          <NavDropdown title="Services" id="basic-nav-dropdown">
            <NavDropdown.Item href="#service1">Service 1</NavDropdown.Item>
            <NavDropdown.Item href="#service2">Service 2</NavDropdown.Item>
            <NavDropdown.Divider />
            <NavDropdown.Item href="#contact">Contact</NavDropdown.Item>
          </NavDropdown>
        </Nav>
      </Navbar.Collapse>
    </Navbar>
  );
};

export default NavigationBar;

```

```
import React from 'react';
import NavigationBar from './components/NavigationBar';

function App() {
  return (
    <div>
      <NavigationBar />
      {/* Other components */}
    </div>
  );
}

export default App;

```

```
const Example = () => {
  const textStyle = {
    fontFamily: 'Arial, sans-serif', // Specify the font family
    fontSize: '20px', // Adjust the font size
    fontWeight: 'bold', // Set font weight (e.g., normal, bold, lighter, etc.)
    color: '#333', // Optional: Set font color
  };

  return (
    <div>
      <p style={textStyle}>This text uses custom font styling.</p>
    </div>
  );
};

export default Examplonline.

```
```
import React from "react";

const Form = () => {
  const inputStyle = {
    width: "300px",
    marginBottom: "20px",
  };

  const containerStyle = {
    display: "flex",
    gap: "20px",
  };

  const labelStyle = {
    display: "block",
    marginBottom: "5px",
    fontWeight: "bold",
  };

  return (
    <div style={containerStyle}>
      <div>
        <label htmlFor="organizationName" style={labelStyle}>
          Organization Name
        </label>
        <input
          type="text"
          id="organizationName"
          name="organizationName"
          style={inputStyle}
        />
      </div>
      <div>
        <label htmlFor="ein" style={labelStyle}>
          EIN
        </label>
        <input type="text" id="ein" name="ein" style={inputStyle} />
      </div>
    </div>
  );
};

export default Form;

```
```
public void fetchUsers() {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    try {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password");
        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT * FROM users");
        while (rs.next()) {
            System.out.println("User ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```
```
import java.sql.*;

public class UserDAO {
    
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String DB_USER = "user";
    private static final String DB_PASSWORD = "password";
    private static final String FETCH_USERS_SQL = "SELECT * FROM users";
    
    // Using a connection pool for better resource management
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
    
    public void fetchUsers() {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(FETCH_USERS_SQL);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                System.out.println("User ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
            }

        } catch (SQLException e) {
            logError(e); // Centralized error handling
        }
    }

    private void logError(SQLException e) {
        System.err.println("Database error: " + e.getMessage());
        // Ideally, use a logging framework like Log4j or SLF4J
    }
}
```
