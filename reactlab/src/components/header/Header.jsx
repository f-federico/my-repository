import React from 'react'
import './header.css'
import CTA from './CTA'
import ME from '../../assets/exolab-nobg.png'
import HeaderSocial from './HeaderSocial'
const Header = () => {
  return (
    <header>
      {/* naming classes bim */}
      <div className="container header__container">
        <h5>Benvenuto in</h5>
        <h1>Exolab</h1>
        <i><h5 className="text-light">La casa del programmatore</h5></i>
        <CTA/>
        <HeaderSocial/>
        <div className='header__me'>
        <div className='header__me-image'>
          <img src={ME} alt='me' />
          </div>
          </div>

          <a href='#contattaci' className='scorri__sotto'>Scorri sotto</a>
      </div>
    </header>
  )
}

export default Header