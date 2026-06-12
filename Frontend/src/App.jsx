import { useState } from "react";


function App(){
  const [ student , setStudent] = useState(null);
  const getStudent = async () => {
    const response = await fetch("https://localhost:8080/students");
    const data = await response.json();
    setStudent(data);
  };
  useEffect(() => {
    getStudent();
  }, []);
  return(
    <div>
      <h1>Student List </h1>
      {
        students.map((student) => (
          <div key = {student.id}>
            <h2>{student.name}</h2>
            <h3>{student.course}</h3>
          </div>
        ))
      }
    </div>
  );
}
export default App;