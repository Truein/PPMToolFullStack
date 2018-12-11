import React, { Component } from "react";

import "./App.css";
import Dashboard from "./components/Dashboard";
import { BrowserRouter as Router, Route } from "react-router-dom";
import AddProject from "./components/Project/AddProject";
import Header from "./components/Layout/Header";

import { provider } from "react-redux";
import store from "./store";

class App extends Component {
  render() {
    return (
      <provider store={store}>
        <Router>
          <div className="App">
            <Header />
            <Route exact path="/dashboard" component={Dashboard} />
            <Route exact path="/addProject" component={AddProject} />
          </div>
        </Router>
      </provider>
    );
  }
}

export default App;
