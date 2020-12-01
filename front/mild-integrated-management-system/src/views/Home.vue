<template>
  <!-- 在Home.vue中顶级根元素使用div, 使用container会导致tab偏移. -->
  <div>
    <!--  app bar begin  -->
    <v-app-bar
      app
      :elevation="appBarShadow"
      clipped-left
      color="primary"
      dark
      height="64"
    >
      <v-app-bar-nav-icon
        class="ml-2"
        @click.stop="isOpenLeftDrawer = !isOpenLeftDrawer"
      ></v-app-bar-nav-icon>
      <v-toolbar-title>
        <!--        <v-avatar-->
        <!--          size="30px"-->
        <!--          color="blue lighten-3"-->
        <!--          class="mx-3"-->
        <!--          style="transform: rotate(180deg)"-->
        <!--        >-->
        <!--          <v-icon dark @click.stop="isOpenLeftDrawer = !isOpenLeftDrawer">-->
        <!--            Mild-->
        <!--          </v-icon>-->
        <!--        </v-avatar>-->
        <span> 轻度综合管理系统 </span>
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <v-toolbar-items>
        <v-btn class="d-md-flex d-none" text @click="fullscreen">
          <v-icon v-text="fullscreenIcon"></v-icon>
        </v-btn>
        <v-btn text @click="showSetting = !showSetting">
          <v-icon>mdi-palette</v-icon>
        </v-btn>
        <v-btn text @click="logout">
          <v-icon>mdi-logout</v-icon>
        </v-btn>
      </v-toolbar-items>
    </v-app-bar>
    <!--  app bar end  -->

    <!--  color setting drawer begin  -->
    <v-navigation-drawer
      v-model="showSetting"
      width="300"
      overlay-opacity="0"
      floating
      temporary
      right
      app
    >
      <v-sheet class="ma-4" color="transparent">
        <v-flex class="mb-3 subtitle-1">主题颜色</v-flex>
        <v-color-picker
          v-model="primarySet"
          width="268"
          canvas-height="100"
          class="mb-3"
          hide-inputs
          flat
          dark
        ></v-color-picker>
        <v-flex class="mb-3 subtitle-1">关键颜色</v-flex>
        <v-color-picker
          v-model="secondarySet"
          width="268"
          canvas-height="100"
          class="mb-3"
          hide-inputs
          flat
          dark
        ></v-color-picker>
        <v-slider
          v-model="appBarShadow"
          color="primary"
          label="应用栏阴影"
          max="8"
          thumb-label
          hide-details
        ></v-slider>
        <v-switch
          v-model="isShowTabsView"
          label="菜单选项卡"
          thumb-label
          hide-details
        ></v-switch>
        <v-switch
          v-model="isShowMiniDrawer"
          label="迷你菜单栏"
          thumb-label
          hide-details
        ></v-switch>
        <v-switch
          v-model="isShowDrawerBackground"
          label="菜单栏背景色"
          hide-details
        ></v-switch>
        <v-switch
          v-model="isShowDarkMode"
          label="夜间模式"
          hide-details
        ></v-switch>
      </v-sheet>
    </v-navigation-drawer>
    <!--  color setting drawer end  -->

    <!--  left drawer begin  -->
    <v-navigation-drawer
      v-model="isOpenLeftDrawer"
      app
      width="250"
      :mini-variant="isShowMiniDrawer"
      mini-variant-width="64"
      src="../assets/background.png"
      :color="isShowDrawerBackground ? 'primary' : null"
      :dark="isShowDrawerBackground"
      hide-overlay
      clipped
      :style="background"
    >
      <v-list flat class="pt-0">
        <template v-for="list in navList">
          <!--    if the element is group, then show group      -->
          <v-list-group
            v-if="list.items.length"
            :key="list.path"
            class="white--text"
            :prepend-icon="list.icon"
            :active-class="
              isShowDrawerBackground || $vuetify.theme.dark
                ? 'white--text'
                : 'grey--text text--darken-3'
            "
            :group="list.group"
          >
            <template v-slot:activator>
              <v-list-item-content>
                <v-list-item-title v-text="list.title"></v-list-item-title>
              </v-list-item-content>
            </template>
            <v-list-item
              v-for="item in list.items"
              :key="item.title"
              active-class="secondary white--text"
              :to="item.path"
            >
              <v-list-item-action
                ><v-icon small class="ml-4" v-text="item.icon"></v-icon
              ></v-list-item-action>
              <v-list-item-content>
                <v-list-item-title v-text="item.title"></v-list-item-title>
              </v-list-item-content>
            </v-list-item>
          </v-list-group>
          <!--     else show the single item       -->
          <v-list-item
            v-else
            :key="list.title"
            active-class="secondary white--text"
            :to="list.path"
            :disabled="list.title === '用户管理' && isDisabledUserItem"
          >
            <v-list-item-action
              ><v-icon
                :style="{
                  color:
                    list.title === '用户管理' && isDisabledUserItem
                      ? 'grey'
                      : '',
                }"
                v-text="list.icon"
              ></v-icon
            ></v-list-item-action>
            <v-list-item-content>
              <v-list-item-title v-text="list.title"></v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </template>
      </v-list>
    </v-navigation-drawer>
    <!--  left drawer end  -->

    <!--  components view page  -->
    <v-main app class="pb-12">
      <!--  Don't use background color for v-main.  -->
      <!--   So annotation this main for backup.   -->
      <!--    <v-main app class="divider pb-12">-->
      <v-expand-transition>
        <v-tabs
          v-show="isShowTabsView && tabList.length"
          color="secondary"
          style="position: sticky; top: 64px;z-index: 5"
          show-arrows
        >
          <v-tab
            v-for="(item, i) in tabList"
            :key="item.name"
            :name="i"
            :to="item.path"
            @contextmenu="showMenu"
          >
            {{ item.title }}
            <v-icon
              size="20"
              @click.stop.prevent="closeCurrentTab(i)"
              @contextmenu.stop.prevent=""
              >mdi-close</v-icon
            >
          </v-tab>
        </v-tabs>
      </v-expand-transition>
      <v-menu
        v-model="isShoTabRightClickMenu"
        :position-x="x"
        :position-y="y"
        absolute
        offset-y
        min-width="110"
      >
        <v-list dense>
          <v-list-item
            v-ripple="{ class: 'secondary--text' }"
            @click="closeCurrentTab(index)"
          >
            <v-list-item-title>关闭</v-list-item-title>
          </v-list-item>
          <v-list-item
            v-ripple="{ class: 'secondary--text' }"
            @click="closeOtherTab(index)"
          >
            <v-list-item-title>关闭其他</v-list-item-title>
          </v-list-item>
          <v-list-item
            v-ripple="{ class: 'secondary--text' }"
            @click="closeAllTab"
          >
            <v-list-item-title>关闭所有</v-list-item-title>
          </v-list-item>
        </v-list>
      </v-menu>

      <keep-alive>
        <router-view app></router-view>
      </keep-alive>
    </v-main>
    <!--  components view page  -->
  </div>
</template>

<script>
// @ is an alias to /src
import screenfull from 'screenfull';
import navList from '@/views/Navigation';

export default {
  name: 'Home',
  components: {
    //
  },

  data() {
    return {
      // this navList, from Navigation.js.
      navList: navList,
      tabList: [],
      showSetting: false,
      isShowTabsView: true,
      isShowMiniDrawer: false,
      isShowDrawerBackground: false,
      isShowDarkMode: false,
      appBarShadow: 6,
      isShoTabRightClickMenu: false,
      background: {
        backgroundImage: `url(${require('../assets/background.png')})`,
        backgroundAttachment: 'fixed',
      },
      fullscreenIcon: 'mdi-fullscreen',
      x: 0,
      y: 0,
      isOpenLeftDrawer: !(
        this.$vuetify.breakpoint.name === 'xs' ||
        this.$vuetify.breakpoint.name === 'sm'
      ),
      isDisabledUserItem: !this.$api.user.getRole(),
    };
  },

  computed: {
    lightPrimary() {
      return this.$vuetify.theme.themes.light.primary;
    },
    lightSecondary() {
      return this.$vuetify.theme.themes.light.secondary;
    },
    darkPrimary() {
      return this.$vuetify.theme.themes.dark.primary;
    },
    darkSecondary() {
      return this.$vuetify.theme.themes.dark.secondary;
    },
    primarySet: {
      get: function() {
        return this.$vuetify.theme.dark
          ? this.$vuetify.theme.themes.dark.primary
          : this.$vuetify.theme.themes.light.primary;
      },
      set: function(newValue) {
        if (this.$vuetify.theme.dark) {
          this.$vuetify.theme.themes.dark.primary = newValue;
        } else {
          this.$vuetify.theme.themes.light.primary = newValue;
        }
      },
    },
    secondarySet: {
      get: function() {
        return this.$vuetify.theme.dark
          ? this.$vuetify.theme.themes.dark.secondary
          : this.$vuetify.theme.themes.light.secondary;
      },
      set: function(newValue) {
        if (this.$vuetify.theme.dark) {
          this.$vuetify.theme.themes.dark.secondary = newValue;
        } else {
          this.$vuetify.theme.themes.light.secondary = newValue;
        }
      },
    },
  },

  watch: {
    $route(to) {
      // 查找tabs里面是否已经包含该路由
      let isCover = this.tabList.some(val => {
        return val.name === to.name;
      });
      !isCover &&
        this.tabList.push({
          name: to.name,
          path: to.path,
          title: to.meta,
        });
    },
    isShowTabsView(val) {
      localStorage.setItem('isShowTabsView', val);
    },
    isShowMiniDrawer(val) {
      localStorage.setItem('isShowMiniDrawer', val);
    },
    isShowDrawerBackground(val) {
      localStorage.setItem('isShowDrawerBackground', val);
    },
    isShowDarkMode(val) {
      this.$vuetify.theme.dark = val;
      localStorage.setItem('isShowDarkMode', val);
    },
    appBarShadow(val) {
      localStorage.setItem('appBarShadow', val);
    },
    lightPrimary(val) {
      localStorage.setItem('lightPrimary', val);
    },
    darkPrimary(val) {
      localStorage.setItem('darkPrimary', val);
    },
    lightSecondary(val) {
      localStorage.setItem('lightSecondary', val);
    },
    darkSecondary(val) {
      localStorage.setItem('darkSecondary', val);
    },
  },

  mounted() {
    // console.log('\n');
    // console.log(this.axios);
    // console.log(this.$store);
    // console.log(this.$vuetify.breakpoint.name);
    console.log('User role is: ' + this.$api.user.getRole());
    // console.log('\n');
    // console.log(navList);
    this.tabList.push({
      name: this.$route.name,
      path: this.$route.path,
      title: this.$route.meta,
    });
    this.isShowTabsView = JSON.parse(
      localStorage.getItem('isShowTabsView') || true
    );
    this.isShowMiniDrawer = JSON.parse(
      localStorage.getItem('isShowMiniDrawer') || false
    );
    this.isShowDrawerBackground = JSON.parse(
      localStorage.getItem('isShowDrawerBackground') || false
    );
    this.isShowDarkMode = JSON.parse(
      localStorage.getItem('isShowDarkMode') || false
    );
    this.appBarShadow = JSON.parse(localStorage.getItem('appBarShadow') || 6);
  },

  methods: {
    fullscreen() {
      this.fullscreenIcon = screenfull.isFullscreen
        ? 'mdi-fullscreen'
        : 'mdi-fullscreen-exit';
      screenfull.toggle();
    },
    logout() {
      localStorage.removeItem('token');
      this.$router.replace('/Login');
    },
    showMenu(e) {
      e.preventDefault();
      this.index = e.target.name;
      this.isShoTabRightClickMenu = false;
      this.x = e.clientX;
      this.y = e.clientY;
      this.$nextTick(() => {
        this.isShoTabRightClickMenu = true;
      });
    },
    closeCurrentTab(index) {
      this.tabList.splice(index, 1);
      if (!this.tabList.length) {
        this.tabList.push({
          name: 'Welcome',
          path: '/Home/Welcome',
          title: '欢迎使用',
        });
        this.$router
          .push({
            name: 'Welcome',
            path: '/Home/Welcome',
          })
          .catch(() => {});
      } else
        this.$router
          .push(this.tabList[this.tabList.length - 1].path)
          .catch(() => {});
    },
    closeOtherTab(index) {
      let list = this.tabList[index];
      this.tabList = [];
      this.tabList.push(list);
      this.$router.push(list.path).catch(() => {});
    },
    closeAllTab() {
      this.tabList = [];
      this.tabList.push({
        name: 'Welcome',
        path: '/Home/Welcome',
        title: '欢迎使用',
      });
      this.$router
        .push({
          name: 'Welcome',
          path: '/Home/Welcome',
        })
        .catch(() => {});
    },
  },
};
</script>
