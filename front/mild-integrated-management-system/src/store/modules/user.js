const state = {
  // -1 means not storage user's role.
  // But this value will be updated when role api function was invoked.
  role: -1,
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
