import React from 'react'

export default function Pokeinfo({ data }) {
    return (
        <>
            {
                (!data) ? "" : (
                    <div>

                        <h1>{data.name} {data.id} </h1>

                        <img src={`https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/dream-world/${data.id}.svg`} alt="sd" />

                        <div className="abilities"  >
                            {
                                data.abilities.map((ab) => {
                                    console.log(ab)
                                    return (

                                        <div className="ability" >
                                            <h2>{ab.ability.name} </h2>
                                        </div>)
                                })
                            }


                            <div className="ability">
                                <h2>solar-power</h2>
                            </div>
                        </div>
                        <div className="base-stat">
                            {
                                data.stats.map(poke => {
                                    return (
                                        <h3>{poke.stat.name}:{poke.base_stat}</h3>
                                    )
                                })
                            }
                        </div>

                    </div>
                )
            }
        </>

    )
}
