import { useState } from "react";


function App(){

  const getStudentData = async () => {
    const response = await fetch('http://localhost:8080/students');
    const data = await response.json();
    setStudent(data);
  }
  return (
    <div>
      <h1>Welcome to my page</h1>
      <button onClick = {getStudentData}>
        Get student data
      </button>
      <h1> This is the student data :</h1>
      <h2> {getStudentData.name}</h2>
      <h3> {getStudentData.course}</h3>
      <h4> {getStudentData.id}</h4>

    </div>
  );
}
export default App;