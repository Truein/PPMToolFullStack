import React, { Component } from "react";
import ProjectItem from "./Project/ProjectItem";
import Header from "./Layout/Header";

class Dashboard extends Component {
  render() {
    return (
      <div>
        <h1>Welcome to Dashboard</h1>

        <Header />
        <ProjectItem />
      </div>
    );
  }
}

export default Dashboard;
