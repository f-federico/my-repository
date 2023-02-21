import React from 'react'
import './nav.css'
import {AiOutlineHome} from 'react-icons/ai'
import {FaUserSecret} from 'react-icons/fa'
import {AiOutlineFundProjectionScreen} from 'react-icons/ai'
import{GiSkills} from 'react-icons/gi'
import {MdConnectWithoutContact} from 'react-icons/md'
import { useState } from 'react'

const Nav = () => {
  const [activeNav, setActiveNav] = useState('#') 
  return (
    <nav>
      <a href='#'  onClick={() => setActiveNav('#')} className={activeNav === '#' ? 'active' : ''}><AiOutlineHome/></a>
      <a href='#dipendenti' onClick={() => setActiveNav('#dipendenti')} className={activeNav === '#dipendenti' ? 'active' : ''}><FaUserSecret/></a>
      <a href='#ruoli'  onClick={() => setActiveNav('#ruoli')} className={activeNav === '#ruoli' ? 'active' : ''}><GiSkills/></a>
      <a href='#progetti'  onClick={() => setActiveNav('#progetti')} className={activeNav === '#progetti' ? 'active' : ''}><AiOutlineFundProjectionScreen/></a>
      <a href='#contattaci'  onClick={() => setActiveNav('#contattaci')} className={activeNav === '#contattaci' ? 'active' : ''}><MdConnectWithoutContact/></a>
      
    </nav>
  )
}

export default Nav