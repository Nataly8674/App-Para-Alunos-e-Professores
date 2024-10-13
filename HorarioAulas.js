import React from 'react';
import { StyleSheet, Text, View } from 'react-native';

export default function HorarioAulas() {
  return (
    <View style={styles.container}>
      <View style={styles.header}>
        <Text style={styles.textoHeader}>Horário das Aulas</Text>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
    backgroundColor: '#2F80ED',
  },
  header: {
    position: "absolute",
    top: 0,
    width: 400,
    height: 55,
    backgroundColor: "#fff",
    elevation: 40,
  },
  textoHeader: {
    fontSize: 24,
    color: '#0073e6',
    marginTop: 10,
    textAlign: 'center',
    fontFamily: 'Nunito-Bold',
  },
});
