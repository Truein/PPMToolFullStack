import React, { Component } from "react";
import ProjectItem from "./Project/ProjectItem";
import Header from "./Layout/Header";
import "bootstrap/dist/css/bootstrap.min.css";
class Dashboard extends Component {
  render() {
    return (
      <div>
        <h1 className="alert alert-warning">Welcome to Dashboard</h1>

        <Header />
        <ProjectItem />
      </div>
    );
  }
}

export default Dashboard;
