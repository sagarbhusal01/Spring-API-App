import React, { useEffect, useState } from 'react'
import { useNavigate, useSearchParams } from 'react-router-dom'

export default function Home() {
  const [UserData,setUserData]=useState<any>();
  const navigate =useNavigate();
  useEffect(()=>
  {
    const val=localStorage.getItem("$USER")
    if(val===null)
    {
      navigate("/Login")
      return;
    }
    setUserData(JSON.parse(val))
  },[])
  return (
    <>
     <div>{UserData?.apikey}</div>
    </>
  )
}
