import React, { Component } from "react";

import "./App.css";
import Dashboard from "./components/Dashboard";
import { BrowserRouter as Router, Route } from "react-router-dom";
import AddProject from "./components/Project/AddProject";
import Header from "./components/Layout/Header";

class App extends Component {
  render() {
    return (
      <Router>
        <div className="App">
          <Header />
          {
            //not working properly
          }
          <Dashboard exact path="/dashboard" Component={Dashboard} />
          <Route exact path="/addProject" Component={AddProject} />
        </div>
      </Router>
    );
  }
}

export default App;
