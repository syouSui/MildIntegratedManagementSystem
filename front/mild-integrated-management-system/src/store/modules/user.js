const state = {
  // -1 means not storage user's role.
  // But this value will be updated when role api function was invoked.
  role: -1,
  user: {},
};
const getters = {
  getRole: state => {
    return state.role;
  },
};
const mutations = {
  setUser: (state, playLoad) => {
    // if (playLoad.userId === null) console.log('1111113123');
    state.user = {
      userId: playLoad.userId,
      username: playLoad.username,
      role: playLoad.role,
      updatedTime: playLoad.updatedTime,
      avatarUrl: playLoad.avatarUrl,
    };
    console.log(state.user);
    state.role = state.user.role;
  },
  removeUser: state => {
    state.user = null;
    state.role = -1;
  },
};
const actions = {};

export default {
  namespaced: true,
  state,
  getters,
  mutations,
  actions,
};
