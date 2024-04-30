import './App.css';
import { useEffect, useRef, useState } from 'react';

function App() {
  const [kogus, setKogus] = useState(0);
  const [arvutid, setArvutid] = useState([]);
  const nimiRef = useRef();
  const valmistajaRef = useRef();
  const maksumusRef = useRef();
  const [pcComponents, setPCComponents] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/api/arvutid")
      .then(response => response.json())
      .then(json => {
        setKogus(json.length);
        setArvutid(json);
      })
  }, []);

  useEffect(() => {
    fetch("http://localhost:8080/pcComponents")
      .then(response => response.json())
      .then(json => {
        setPCComponents(json);
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

  function kustutaAC(primaarvoti) {
    fetch("http://localhost:8080/pcComponents/" + primaarvoti, {"method": "DELETE"})
      .then(response => response.json())
      .then(json => {
        setPCComponents(json);
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
    fetch("http://localhost:8080/api/arvutid", 
    {
      "method": "POST", 
      "body": JSON.stringify(arvuti), 
      "headers": {"Content-Type": "application/json"}
    })
      .then(response => response.json())
      .then(json => {
        setKogus(json.length);
        setArvutid(json);
      })
  }

  const aNimiRef = useRef();
  const kogusRef = useRef();

  function lisaAC() {
    const lisatavAC = {
      "pc": {"nimetus": aNimiRef.current.value},
      "kogus": kogusRef.current.value
    }
    fetch("http://localhost:8080/pcComponents", 
    {
      "method": "POST", 
      "body": JSON.stringify(lisatavAC),
      "headers": {"Content-Type": "application/json"}
    })
      .then(response => response.json())
      .then(json => {
        setPCComponents(json);
      })
  }

  /* function lisaOwner() {
    const lisatavOwner = {
      "pccomponentslist": [pccomponentsRef.current.value],
      "nimetus": nimetusRef.current.value
    }
    fetch("http://localhost:8080/owner", 
    {
      "method": "POST", 
      "body": JSON.stringify(lisatavOwner),
      "headers": {"Content-Type": "application/json"}
    })
      .then(response => response.json())
      .then(json => {
        setOwner(json);
      })
  } */

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

      {arvutid.map(a => <div>{a.nimetus} | {a.valmistaja} | {a.maksumus} <button onClick={() => kustuta(a.nimetus)}>x</button></div>)}
      <hr />

      <label>Arvuti nimetus</label> <br/>
      <input ref={aNimiRef} type="text" /> <br />
      <label>Kogus</label> <br/>
      <input ref={kogusRef} type="text" /> <br />
      <button onClick={() => lisaAC()}>Sisesta</button> <br />
      <br />
      {pcComponents.map(ac => <div>{ac.id} | {ac.pc?.nimetus} | {ac.kogus} <button onClick={() => kustutaAC(ac.id)}>x</button></div>)}
    </div>
  );
}

export default App;
