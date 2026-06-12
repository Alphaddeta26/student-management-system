import { useEffect, useState} from "react";

function App(){
  const [students, setStudents] = useState([]);
  const[count, setCount] = useState(0);

  const [name, setName] = useState("");
  const [course, setCourse] = useState("");

  const getStudents = async () => {
    const response = await fetch("https://localhost:8080/students/bca");
    const data = await response.json();
    setStudents(data);

  };
  useEffect(() => {

    fetch("https://localhost:8080/students/count")
    .then(res => res.json())
    .then(data => setCount(data));
  }
  const addStudent =async () => {
    await fetch("https://localhost:8080/students/add", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify({name, course})
    });

    setName("");
    setCourse("");
    getStudents();  
  };

  return(
    <div style={{ padding: "40px" }}>

      <input
        type="text"
        placeholder="Enter Name"
        value={name}
        onChange={(e) => setName(e.target.value)}
      />

      <br /><br />

      <input
        type="text"
        placeholder="Enter Course"
        value={course}
        onChange={(e) => setCourse(e.target.value)}
      />

      <br /><br />

      <button onClick={addStudent}>
        Add Student
      </button>

      <hr />

      <button onClick={getStudents}>
        Get Students
      </button>

      <button onClick={getBCAStudents}>
         Show BCA students
      </button>

      <ul>
        {students.map(student => (
          <li key={student.id}>
              {student.name} - {student.course}
          </li>
        ))}
      </ul>


      <button onClick={fetchTotalStudentCount}>
        Get Total Student Count
      </button>

      <p>Total students: {count}</p>




    </div>
  );
}

export default App;