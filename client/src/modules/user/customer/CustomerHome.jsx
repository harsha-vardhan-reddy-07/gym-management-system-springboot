import React, { useState, useContext } from 'react'
import { Link } from 'react-router-dom';
import Navbar from 'react-bootstrap/Navbar';
import { Container, Nav } from 'react-bootstrap';
import PropTypes from 'prop-types';
import Tabs from '@mui/material/Tabs';
import Tab from '@mui/material/Tab';
import Typography from '@mui/material/Typography';
import Box from '@mui/material/Box';
import AllPlans from './AllPlans';
import MyPlans from './MyPlans';



function CustomTabPanel(props) {
   const { children, value, index, ...other } = props;

   return (
      <div
         role="tabpanel"
         hidden={value !== index}
         id={`simple-tabpanel-${index}`}
         aria-labelledby={`simple-tab-${index}`}
         {...other}
      >
         {value === index && (
            <Box sx={{ p: 3 }}>
               <Typography>{children}</Typography>
            </Box>
         )}
      </div>
   );
}

CustomTabPanel.propTypes = {
   children: PropTypes.node,
   index: PropTypes.number.isRequired,
   value: PropTypes.number.isRequired,
};

function a11yProps(index) {
   return {
      id: `simple-tab-${index}`,
      'aria-controls': `simple-tabpanel-${index}`,
   };
}
const CustomerHome = () => {
   // const user = useContext(UserContext)
   const [value, setValue] = useState(0);

   const handleChange = (event, newValue) => {
      setValue(newValue);
   };

   const handleLogOut = () => {
      localStorage.clear();
      for (let key in localStorage) {
         if (localStorage.hasOwnProperty(key)) {
         localStorage.removeItem(key);
         }
      }
      
      navigate('/');
   }

   // if (!user) {
   //    return null;;
   // }

   return (
      <div>
         <Navbar expand="lg" className="bg-body-tertiary">
            <Container fluid>
               <Navbar.Brand><h2>GymPro</h2></Navbar.Brand>
               <Navbar.Toggle aria-controls="navbarScroll" />
               <Navbar.Collapse id="navbarScroll">
                  <Nav
                     className="me-auto my-2 my-lg-0"
                     style={{ maxHeight: '100px' }}
                     navbarScroll
                  >
                  </Nav>
                  <Nav>
                     <h5 className='mx-3'>Hi {localStorage.getItem("username")}</h5>
                     <Link onClick={handleLogOut} to={'/'}>Log Out</Link>
                  </Nav>

               </Navbar.Collapse>
            </Container>
         </Navbar>

         <Box sx={{ width: '100%' }}>
            <Box sx={{ borderBottom: 1, borderColor: 'divider' }}>
               <Tabs value={value} onChange={handleChange} aria-label="basic tabs example">
                  <Tab label="Plans" {...a11yProps(0)} />
                  <Tab label="My plans" {...a11yProps(1)} />
                  {/* <Tab label="All Bookings" {...a11yProps(2)} /> */}
               </Tabs>
            </Box>
            <CustomTabPanel value={value} index={0}>
               <AllPlans />
            </CustomTabPanel>
            <CustomTabPanel value={value} index={1}>
               <MyPlans />
            </CustomTabPanel>

         </Box>
      </div>
   )
}

export default CustomerHome


