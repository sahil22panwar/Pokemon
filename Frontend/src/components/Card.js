import React from 'react'


export default function Card({ pokemon, loading, setPokemonData }) {
    const setPokeData = (item) => {
        console.log(item, 'card')
        setPokemonData(item)
    }
    return (
        <>
            {
                loading ? <h1>loading...</h1> :
                    pokemon.map((item) => {

                        return (
                            <div className="card" key={item.id} >
                                <h2>{item.id}:{item.attack}</h2>

                                <img src={item.sprites.front_default} alt="" />
                                <h2>{item.name}</h2>
                                <button onClick={() => setPokeData(item)}>read more</button>

                            </div>
                        )

                    })
            }

        </>

    )
}

