import Vue from 'vue';
import Vuetify from 'vuetify/lib';

Vue.use(Vuetify);

export default new Vuetify({
  theme: {
    themes: {
      light: {
        primary: localStorage.getItem('lightPrimary') || '#335c7b',
        secondary: localStorage.getItem('lightSecondary') || '#3d436a',
        accent: '#ff5722',
        divider: '#fafafa',
        error: '#e91e63',
        warning: '#ffc107',
        info: '#84acbf',
        success: '#8bc34a',
      },
      dark: {
        primary: localStorage.getItem('darkPrimary') || '#304a76',
        secondary: localStorage.getItem('darkSecondary') || '#73657f',
        accent: '#232f34',
        divider: '#121212',
        error: '#e91e63',
        warning: '#ffc107',
        info: '#84acbf',
        success: '#8bc34a',
      },
    },
  },
});
