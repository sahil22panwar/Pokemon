import React, { useState } from 'react'
import './Style.css'
import Card from './Card'
import Pokeinfo from './Pokeinfo'
import axios from 'axios'
export default function Main() {
    const [pokedata, setPokeData] = useState([]);
    const [loading, setLoading] = useState(true);
    const [url, setUrl] = useState("https://pokeapi.co/api/v2/pokemon/?offset=0&limit=20");
    const [nextUrl, setNextUrl] = useState([]);
    const [previousUrl, setPreviousUrl] = useState('');
    const [pokemonData, setPokemonData] = useState();
    let seedingData = [];

    console.log(pokedata)
    const pokeFun = async () => {
        setLoading(true)
        const res = await axios.get(url);
        seedingData.push(res)
        console.log(res);
        setNextUrl(res.data.next);
        setPreviousUrl(res.data.previous);
        getPokemon(res.data.results)
        setLoading(false);
    }

    const getPokemon = async (res) => {
        res.map(async (item) => {
            const result = await axios.get(item.url);
            setPokeData(state => {
                state = [...state, result.data];
                state.sort((a, b) => a.id > b.id ? 1 : -1)
                return state;
            })
        })
    }

    async function postDataToBackend(pokedata) {
        console.log(seedingData)
        console.log("post -->", pokedata)
        try {
            const response = await axios.post('http://localhost:8083/api/vi/addPokemon', pokedata);
            console.log('Data sent to the backend:', response);
        } catch (error) {
            console.error('Error sending data to the backend:', error);
        }
    }
    async function prepareData() {
        pokeFun();
    }
    return (
        <div>
            <header>
                <h1 >Go Pokemon!!</h1>
            </header>
            <div className="container">
                <div className="left-content">
                    <div className='btn'>
                        <button onClick={() => postDataToBackend(pokedata)} >Sync data</button>
                        <button onClick={() => prepareData()}>Prepare data</button>
                    </div>
                    <Card pokemon={pokedata} loading={loading} setPokemonData={setPokemonData} />
                    <div className="btn">{
                        <button onClick={() => setUrl(previousUrl)}>Previous</button>}{
                            <button onClick={() => setUrl(nextUrl)}>Next</button>}
                    </div>
                </div>
                <div className="right-content">
                    <Pokeinfo data={pokemonData} />
                </div>
            </div>
        </div>
    )
}
