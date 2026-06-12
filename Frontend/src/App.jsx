import { useEffect, useState} from "react";

function App(){
  const [students, setStudents] = useState([]);
  const getStudents = async () => {
    const response = await fetch("https://localhost:8080/students/bca");
    const data = await response.json();
    setStudents(data);

  };
  useEffect(() => {

    fetch("https://localhost:8080/students/count")
    .then(res => res.json())
    .then(data => setCount(data));
  }, []);
  return(
    <div>
      <h1> Total Students: {count}</h1>
      </div>
  );
}

export default App;