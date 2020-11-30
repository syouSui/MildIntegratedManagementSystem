const state = {
  role: 2,
};
const getters = {
  getState: state => {
    return state.role;
  },
};
const mutations = {};
const actions = {};

export default {
  namespaced: true,
  state,
  getters,
  mutations,
  actions,
};
