import './App.css';
import { useEffect, useRef, useState } from 'react';

function App() {
  const [kogus, setKogus] = useState(0);
  const [arvutid, setArvutid] = useState([]);
  const nimiRef = useRef();
  const valmistajaRef = useRef();
  const maksumusRef = useRef();

  useEffect(() => {
    fetch("http://localhost:8080/api/arvutid")
      .then(response => response.json())
      .then(json => {
        setKogus(json.length);
        setArvutid(json);
      })
  }, []);

  function kustuta(primaarvoti) {
    fetch("http://localhost:8080/api/arvutid/" + primaarvoti, {"method": "DELETE"})
      .then(response => response.json())
      .then(json => {
        setKogus(json.length);
        setArvutid(json);
      })
  }

  function lisa(){
    if (nimiRef.current.value.trim() === "") {
      return;
    }
    const arvuti = {
      "nimetus": nimiRef.current.value,
      "valmistaja": valmistajaRef.current.value,
      "maksumus": maksumusRef.current.value,
    }
    fetch("http://localhost:8080/api/arvutid", {"method": "POST", "body": JSON.stringify(arvuti), "headers": {"Content-Type": "application/json"}})
      .then(response => response.json())
      .then(json => {
        setKogus(json.length);
        setArvutid(json);
      })
  }

  return (
    <div className="App">
      Andmebaasis on {kogus} arvutit.
      <br /><br />

      <label>Arvuti nimetus</label> <br/>
      <input ref={nimiRef} type="text" /> <br />
      <label>Valmistaja</label> <br/>
      <input ref={valmistajaRef} type="text" /> <br />
      <label>Maksumus</label> <br/>
      <input ref={maksumusRef} type="text" /> <br />
      <button onClick={() => lisa()}>Sisesta</button> <br />
      <br />

      {arvutid.map(a => <div>{a.nimetus} <button onClick={() => kustuta(a.nimetus)}>x</button></div>)}
    </div>
  );
}

export default App;
