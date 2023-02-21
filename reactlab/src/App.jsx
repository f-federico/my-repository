import React from 'react'
import Header from './components/header/Header'
import Nav from './components/nav/Nav'
import Dipendenti from './components/dipendenti/Dipendenti'
import Ruoli from './components/ruoli/Ruoli'
import Progetti from './components/progetti/Progetti'
import Contattaci from './components/contattaci/Contattaci'
import Footer from './components/footer/Footer'

const App = () => {
  return (
    <>
    <Header/>
    <Nav/>
    <Dipendenti/>
    <Ruoli/>
    <Progetti/>
    <Contattaci/>
    <Footer/>

    </>
  )
}

export default App