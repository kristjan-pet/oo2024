import './App.css';
import { useEffect, useRef, useState } from 'react';

function App() {
  const [rivers, setRivers] = useState([]);
  const nimetusRef = useRef();
  const lahtmexRef = useRef();
  const lahtmeyRef = useRef();
  const suudmexRef = useRef();
  const suudmeyRef = useRef();
  const kiirusRef = useRef();

  useEffect(() => {
    fetch("http://localhost:8080/rivers")
      .then(response => response.json())
      .then(json => {
        setRivers(json);
      })
  }, []);

  function lisa(){
    if (nimetusRef.current.value.trim() === "") {
      return;
    }
    const river = {
      "nimetus": nimetusRef.current.value,
      "lahtmex": lahtmexRef.current.value,
      "lahtmey": lahtmeyRef.current.value,
      "suudmex": suudmexRef.current.value,
      "suudmey": suudmeyRef.current.value,
      "kiirus": kiirusRef.current.value
    }
    fetch("http://localhost:8080/rivers", 
    {
      "method": "POST", 
      "body": JSON.stringify(river), 
      "headers": {"Content-Type": "application/json"}
    })
      .then(response => response.json())
      .then(json => {
        setRivers(json);
      })
  }

  function kustuta(primaarvoti) {
    fetch("http://localhost:8080/rivers/" + primaarvoti, {"method": "DELETE"})
      .then(response => response.json())
      .then(json => {
        setRivers(json);
      })
  }

  return (
    <div className="App">
      <label>Jõe nimetus</label> <br/>
      <input ref={nimetusRef} type="text" /> <br />
      <label>Lähtme x koordinaat</label> <br/>
      <input ref={lahtmexRef} type="text" /> <br />
      <label>Lähtme y koordinaat</label> <br/>
      <input ref={lahtmeyRef} type="text" /> <br />
      <label>Suudme x koordinaat</label> <br/>
      <input ref={suudmexRef} type="text" /> <br />
      <label>Suudme y koordinaat</label> <br/>
      <input ref={suudmeyRef} type="text" /> <br />
      <label>Jõe kiirus</label> <br/>
      <input ref={kiirusRef} type="text" /> <br />
      <button onClick={() => lisa()}>Sisesta</button> <br />

      {rivers.map(r => <div>{r.nimetus} | Lähe: {r.lahtmex}, {r.lahtmey} | Suue: {r.suudmex}, {r.suudmey} | Kiirus: {r.kiirus} m/s <button onClick={() => kustuta(r.id)}>x</button></div>)}
    </div>
  );
}

export default App;
