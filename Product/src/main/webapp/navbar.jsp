<!DOCTYPE html>
<html>
<head>
  <link type="text/css" rel="stylesheet" href="css/style.css">
  <title>Spring Boot MVC</title>
  <style>
    h1 {
      text-align: center;
      color: white;
    }

    ul {
      list-style-type: none;
      margin: 0;
      padding: 0;
      overflow: hidden;
      background-color: #333;
    }

    li {
      float: left;
    }

    li a {
      display: block;
      color: white;
      text-align: center;
      padding: 14px 16px;
      text-decoration: none;
      background-color: #333; 
      border: 1px solid #fff; 
      border-radius: 5px; 
      transition: background-color 0.3s, border-color 0.3s;
    }

    li a:hover {
      background-color: #555; 
      border-color: #fff; 
    }

    .login-tab {
      position: fixed;
      top: 50%;
      right: 0;
      background-color: #333;
      color: white;
      padding: 10px;
      transform: translateY(-50%);
      z-index: 1;
    }
  </style>
</head>
<body>
  <h1>Pet Adoption Project</h1>

  <ul>
    <li><a href="/">Home</a></li>
    <li><a href="adminlogin">Admin</a></li>
  </ul>
</body>
</html>
