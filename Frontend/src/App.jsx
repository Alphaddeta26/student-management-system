import { useState } from "react";


function App(){
  const [ student , setStudent] = useState(null);
  const getStudent = async () => {
    const response = await fetch("https://localhost:8080/students");
    const data = await response.json();
    setStudent(data);
  };
  return(
    <div style = {{ padding: "40px"}}>
      <button onClick = {getStudent}>
        Get Student
      </button>
      {
        student &&(
          <div>
            <h3>
              ID : {student.id}
            </h3>
            <h2>Name : {student.name}</h2>
            <h3>Age : {student.age}</h3>
          </div>
        )
      }
    </div>
  );
}
export default App;