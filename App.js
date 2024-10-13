import { NavigationContainer } from '@react-navigation/native';
import React from 'react';
import { AppRoutes } from "./src/routes/index"

export default function App() {
  return (
    <NavigationContainer>
      <AppRoutes />


    </NavigationContainer>

  );
}

