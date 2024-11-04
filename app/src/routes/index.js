import { createStackNavigator } from '@react-navigation/stack';
import React from 'react';
import { TelaLogin } from '../../TelaLogin';
import HorarioAulas from '../../HorarioAulas';
import PainelInicial from '../../PainelInicial';
import TelaChamada from '../../TelaChamada';


const { Navigator, Screen } = createStackNavigator();

export function AppRoutes() {
  return (
    <Navigator
      screenOptions={{
        headerShown: false,
        cardStyle: {
          backgroundColor: '#fff',
        },
      }}
    >
      <Screen name="TelaLogin" component={TelaLogin} />
      <Screen name="HorarioAulas" component={HorarioAulas} />
      <Screen name='PainelInicial' component={PainelInicial}/>
      <Screen name='TelaChamada' component={TelaChamada}/>
    </Navigator>
  );

}


