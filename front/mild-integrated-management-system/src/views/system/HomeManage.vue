<template>
  <v-container fluid app class="my-6 mx-3">
    <p>HomeManage</p>
    <!--    id and homeTypeId-->
    <v-row align="center" class="px-4 mt-n6 mb-n10">
      <v-col cols="12" sm="12" md="4" lg="2" xl="4" class="mb-n12 mb-lg-0">
        <v-row align-content="start" justify="center">
          <v-switch
            v-model="checkboxItems[0]"
            dense
            class="pt-2 ml-n7 mr-n3"
          ></v-switch>
          <v-col cols="10" sm="11" md="10" lg="8" style="padding:0;margin:0;">
            <v-text-field
              :disabled="!checkboxItems[0]"
              :readonly="!checkboxItems[0]"
              dense
              outlined
              label="ID"
              prepend-inner-icon="mdi-map-marker"
              class="pt-4 pl-2"
            ></v-text-field>
          </v-col>
        </v-row>
      </v-col>
      <v-col
        cols="12"
        sm="12"
        md="8"
        lg="10"
        xl="8"
        class="pt-6 pl-4 pr-8 mt-xs-n10 mt-n2 mb-md-n13"
      >
        <v-row align-content="start" class="mt-lg-n11">
          <v-switch v-model="checkboxItems[1]" dense class="ml-n2"></v-switch>
          <v-col cols="10" sm="11" md="10" lg="11" class="px-0">
            <v-combobox
              v-model="homeTypeIdList"
              :disabled="!checkboxItems[1]"
              :readonly="!checkboxItems[1]"
              :items="selectItems"
              label="房屋类型"
              multiple
              chips
              dense
            >
              <template v-slot:selection="data">
                <v-chip
                  :key="JSON.stringify(data.item)"
                  v-bind="data.attrs"
                  :input-value="data.selected"
                  :disabled="data.disabled"
                  @click:close="data.parent.selectItem(data.item)"
                >
                  <v-avatar
                    class="accent white--text"
                    left
                    v-text="data.item.slice(0, 1).toUpperCase()"
                  ></v-avatar>
                  {{ data.item }}
                </v-chip>
              </template>
            </v-combobox>
          </v-col>
        </v-row>
      </v-col>
    </v-row>
    <!--    title-->
    <v-row class="px-4 mt-md-10 mt-lg-n11 ml-lg-n11">
      <v-col cols="12">
        <v-row justify="center" class="pr-6">
          <v-switch
            v-model="checkboxItems[2]"
            dense
            class="ml-n1 mr-n4"
          ></v-switch>
          <v-col lg="11">
            <v-text-field
              :disabled="!checkboxItems[2]"
              :readonly="!checkboxItems[2]"
              outlined
              label="标题"
              prepend-inner-icon="mdi-map-marker"
              dense
            ></v-text-field>
          </v-col>
        </v-row>
      </v-col>
    </v-row>
    <!--    date-->
    <v-row class="px-2 pr-lg-4 mt-n10 mr-sm-4 mt-lg-n12">
      <v-spacer></v-spacer>
      <v-col cols="12" md="4" lg="4">
        <v-text-field label="开始日期" outlined dense readonly></v-text-field>
      </v-col>
      <v-col
        cols="12"
        md="4"
        lg="4"
        align="center"
        class="mt-n10 mb-n3 mx-md-n16 mt-md-0"
      >
        <v-dialog v-model="dateDialog" width="290" height="400">
          <template v-slot:activator="{ on, attrs }">
            <v-btn
              color="accent"
              dark
              v-bind="attrs"
              v-on="on"
              @click="checkboxItems[3] = !checkboxItems[3]"
            >
              选择日期
            </v-btn>
            <v-btn
              color="accent darken-1"
              dark
              class="ml-8"
              @click="dates = ''"
            >
              清除日期
            </v-btn>
          </template>
          <v-card>
            <v-date-picker v-model="dates" range></v-date-picker>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="primary" text @click="dateDialog = false">
                确定
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
      </v-col>
      <v-col cols="12" md="4" lg="4">
        <v-text-field label="结束日期" outlined dense readonly></v-text-field>
      </v-col>
      <v-spacer></v-spacer>
    </v-row>
    <!--    price-->
    <v-row class="mt-n8 mr-sm-4 mt-lg-n9 ">
      <!--      <v-col cols="2" class="mt-n3 mr-n5"> </v-col>-->
      <v-spacer></v-spacer>
      <v-col cols="5" sm="5" md="2" lg="2">
        <v-text-field
          label="最低价格"
          outlined
          dense
          :readonly="!checkboxItems[4]"
          :disabled="!checkboxItems[4]"
          append-icon="mdi-map-marker"
        ></v-text-field>
      </v-col>
      <v-col
        cols="1"
        sm="2"
        md="2"
        lg="2"
        class="ml-n4 mt-n3 mr-3 ml-sm-1 mr-sm-n16 mt-md-n2 mr-md-n16 mt-lg-n2 ml-lg-10 mr-lg-n16"
      >
        <v-switch v-model="checkboxItems[4]" dense></v-switch>
      </v-col>
      <v-col cols="5" sm="5" md="2" lg="2" class="ml-md-n15 ml-lg-n16">
        <v-text-field
          label="最高价格"
          outlined
          dense
          :readonly="!checkboxItems[4]"
          :disabled="!checkboxItems[4]"
          prepend-inner-icon="mdi-map-marker"
        ></v-text-field>
      </v-col>
      <v-spacer></v-spacer>
    </v-row>
    <!--    select and clear-->
    <v-row class="mt-0 mb-10 px-4 mt-sm-1 mt-md-n2 mt-lg-n2 mb-lg-n2">
      <v-spacer></v-spacer>
      <v-btn
        class="pa-6 px-8 font-weight-black text-h6"
        :loading="queryBtnLoading"
        :disabled="queryBtnLoading"
        color="success"
        @click="queryBtnLoader = 'queryBtnLoading'"
      >
        综合查询
        <template v-slot:queryBtnLoader>
          <span>Loading...</span>
        </template>
      </v-btn>
      <div class="mx-6"></div>
      <v-btn
        class="pa-6 px-8 font-weight-black text-h6"
        :loading="clearBtnLoading"
        :disabled="clearBtnLoading"
        color="info"
        @click="clearBtnLoader = 'clearBtnLoading'"
      >
        全部清除
        <template v-slot:clearBtnLoader>
          <span>Loading...</span>
        </template>
      </v-btn>
      <v-spacer></v-spacer>
    </v-row>
    <!--    table area-->
    <v-row class="mt-n1 font-weight-medium">
      <v-col justify="center" align="center">
        <v-data-table
          :headers="headers"
          :items="tableData"
          :loading="tableLoading"
          sort-by="home_id"
          class="elevation-1"
        >
          <template v-slot:top>
            <v-toolbar flat>
              <!--              Table Name-->
              <v-toolbar-title>{{ name }}</v-toolbar-title>
              <v-divider class="mx-4" inset vertical></v-divider>
              <v-spacer></v-spacer>
              <!--              Dialog for Insert and Update-->
              <v-dialog
                v-model="dialogForInsertAndUpdate"
                max-width="800px"
                max-height="500"
              >
                <template v-slot:activator="{ on, attrs }">
                  <v-btn
                    color="primary"
                    dark
                    class="mb-2 px-6"
                    v-bind="attrs"
                    v-on="on"
                  >
                    新建项
                  </v-btn>
                </template>
                <v-card>
                  <v-card-title class="pt-12 pl-12">
                    <span class="headline">{{ formTitle }}</span>
                  </v-card-title>
                  <v-card-text class="px-12 py-0">
                    <v-container>
                      <v-row>
                        <v-col cols="12" sm="6" md="6" lg="6">
                          <v-text-field
                            v-model="editedItem.homeId"
                            label="Home id"
                            readonly
                            disabled
                          ></v-text-field>
                        </v-col>
                        <v-col cols="12" sm="6" md="6" lg="6">
                          <v-text-field
                            v-model="editedItem.price"
                            label="Price"
                          ></v-text-field>
                        </v-col>
                        <v-col cols="12">
                          <v-text-field
                            v-model="editedItem.title"
                            label="Title"
                          ></v-text-field>
                        </v-col>
                        <v-col cols="12" sm="6" md="6" lg="6">
                          <v-text-field
                            v-model="editedItem.updatedTime"
                            label="Updated Time"
                            readonly
                            disabled
                          ></v-text-field>
                        </v-col>
                        <v-col cols="12" sm="6" md="6" lg="6">
                          <v-select
                            v-model="editedItem.homeTypeId"
                            :items="selectItems"
                            label="Home Type"
                          ></v-select>
                        </v-col>
                      </v-row>
                    </v-container>
                  </v-card-text>
                  <v-card-actions class="pb-8 pr-8">
                    <v-spacer></v-spacer>
                    <v-btn
                      color="blue darken-1"
                      text
                      @click="closeInsertAndUpdate"
                    >
                      Cancel
                    </v-btn>
                    <v-btn color="blue darken-1" text @click="save">
                      Save
                    </v-btn>
                  </v-card-actions>
                </v-card>
              </v-dialog>
              <!--              Dialog for Delete-->
              <v-dialog v-model="dialogForDelete" max-width="500px">
                <v-card>
                  <v-card-title class="headline"
                    >Are you sure you want to delete this item?</v-card-title
                  >
                  <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn color="blue darken-1" text @click="closeDelete"
                      >Cancel</v-btn
                    >
                    <v-btn color="blue darken-1" text @click="deleteItemConfirm"
                      >OK</v-btn
                    >
                    <v-spacer></v-spacer>
                  </v-card-actions>
                </v-card>
              </v-dialog>
            </v-toolbar>
          </template>
          <!--          Button for Edit and Delete in line-->
          <template v-slot:item.actions="{ item }">
            <v-icon small class="mr-2" @click="editItem(item)">
              mdi-pencil
            </v-icon>
            <v-icon small @click="deleteItem(item)">
              mdi-delete
            </v-icon>
          </template>
          <template v-slot:no-data>
            <v-btn color="primary" @click="initialize">
              Reset
            </v-btn>
          </template>
        </v-data-table>
        <v-snackbar v-model="snack" :timeout="3000" :color="snackColor">
          {{ snackText }}
          <template v-slot:action="{ attrs }">
            <v-btn v-bind="attrs" text @click="snack = false">
              Close
            </v-btn>
          </template>
        </v-snackbar>
        <v-col xs="12" sm="8" md="6" lg="6" xl="6" cols="6" justify="center">
          <v-pagination v-model="pageNum" :length="pageTotal"></v-pagination>
        </v-col>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: 'HomeManage',

  data: () => ({
    name: '房屋信息一览表',
    dialogForInsertAndUpdate: false,
    dialogForDelete: false,
    headers: [
      { text: 'ID', align: 'start', value: 'homeId' },
      { text: '标题', align: 'center', value: 'title' },
      { text: '价格', value: 'price' },
      { text: '更新时间', value: 'updatedTime' },
      { text: '房屋类型', value: 'homeTypeId' },
      { text: '编辑项', value: 'actions', sortable: false },
    ],
    tableData: [],
    editedIndex: -1,
    editedItem: {
      homeId: 'DEFAULT',
      title: 0,
      price: 0,
      updatedTime: 'NOW',
      homeTypeId: 0,
    },
    defaultItem: {
      homeId: 'DEFAULT',
      title: 0,
      price: 0,
      updatedTime: 'NOW',
      homeTypeId: 0,
    },
    selectItems: [
      '一室一厅一卫',
      '两室一厅一卫',
      '三室一厅一卫',
      '四室一厅一卫',
      '五室一厅二卫',
      '六室一厅二卫',
      '双层别墅',
      '三层别墅',
      '四层别墅',
      '五层别墅',
      '六层别墅',
      '高层水景公寓',
      '豪华海景别墅',
      '山景别墅',
      '普通公寓',
      '四合院',
    ],
    pageNum: 0,
    pageTotal: 0,
    snack: '',
    snackColor: '',
    snackText: '',
    tableLoading: true,
    checkboxItems: [false, false, false, false, false],
    homeTypeIdList: [],
    dateDialog: false,
    dates: '',
    queryBtnLoader: null,
    queryBtnLoading: false,
    clearBtnLoader: null,
    clearBtnLoading: false,
  }),

  computed: {
    formTitle() {
      return this.editedIndex === -1 ? '新建项' : '编辑项';
    },
  },

  watch: {
    dialogForInsertAndUpdate(val) {
      if (val) {
        this.snack = true;
        this.snackColor = 'info';
        this.snackText = `${
          this.editedIndex === -1 ? 'New item dialog' : 'Edit item dialog'
        } opened!`;
      }
      val || this.closeInsertAndUpdate();
    },
    dialogForDelete(val) {
      if (val) {
        this.snack = true;
        this.snackColor = 'info';
        this.snackText = `${
          this.editedIndex === -1 ? 'New item dialog' : 'Edit item dialog'
        } closed!`;
      }
      val || this.closeDelete();
    },
    pageNum(val) {
      // console.log(val);
      this.tableLoading = true;
      this.$api.home
        .select({ pageNum: val })
        .then(resp => {
          this.tableData = resp.data.data.content;
          this.pageTotal = resp.data.data.pageTotal;
          this.tableLoading = false;
          // console.log(resp);
        })
        .catch(err => {
          console.error(err);
        });
    },
    queryBtnLoader() {
      const l = this.queryBtnLoader;
      this[l] = !this[l];

      setTimeout(() => (this[l] = false), 3000);

      this.queryBtnLoader = null;
    },
    clearBtnLoader() {
      const l = this.clearBtnLoader;
      this[l] = !this[l];

      setTimeout(() => (this[l] = false), 3000);

      this.clearBtnLoader = null;
    },
  },

  created() {
    this.initialize();
    console.log(this.$vuetify.breakpoint.name);
  },

  methods: {
    initialize() {
      this.pageNum = 1;
    },

    editItem(item) {
      this.editedIndex = this.tableData.indexOf(item);
      this.editedItem = Object.assign({}, item);
      this.dialogForInsertAndUpdate = true;
    },

    closeInsertAndUpdate() {
      this.dialogForInsertAndUpdate = false;
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultItem);
        this.editedIndex = -1;
      });
    },

    save() {
      let obj = this.editedItem;
      if (this.editedIndex > -1) {
        // Update Item
        let indexOfThisObjectInTableData = this.editedIndex;
        this.tableLoading = true;
        this.$api.home
          .update(obj)
          .then(resp => {
            if (resp.data.data === 1) {
              this.tableLoading = false;
              this.snack = true;
              this.snackColor = 'success';
              this.snackText = 'Update successfully!';
              // console.log('Modify successfully!');
              this.$api.home
                .select({ pageNum: '1', homeId: obj.homeId })
                .then(resp => {
                  Object.assign(
                    this.tableData[indexOfThisObjectInTableData],
                    resp.data.data.content[0]
                  );
                });
            } else {
              // console.log(resp);
              this.tableLoading = false;
              this.snack = true;
              this.snackColor = 'error';
              this.snackText = "Server happened error! Don't update data!";
            }
          })
          .catch(err => {
            this.tableLoading = false;
            this.snack = true;
            this.snackColor = 'error';
            this.snackText = 'Local js happened error!';
            console.log(err);
          });
      } else {
        // Insert Item
        this.tableLoading = true;
        this.$api.home
          .insert(obj)
          .then(resp => {
            if (resp.data.data === 1) {
              // console.log('insert successfully');
              this.tableLoading = false;
              this.snack = true;
              this.snackColor = 'success';
              this.snackText = 'Insert successfully!';
              this.$api.home
                .select({ pageNum: this.pageTotal })
                .then(resp => {
                  this.tableData = resp.data.data.content;
                  this.pageTotal = resp.data.data.pageTotal;
                  this.pageNum = this.pageTotal;
                })
                .catch(err => {
                  console.log(err);
                  //
                });
            } else {
              // console.log(resp);
              this.tableLoading = false;
              this.snack = true;
              this.snackColor = 'error';
              this.snackText = "Server happened error! Don't insert data!";
            }
          })
          .catch(err => {
            this.tableLoading = false;
            this.snack = true;
            this.snackColor = 'error';
            this.snackText = 'Local js happened error!';
            console.log(err);
          });
        // this.tableData.push(this.editedItem);
      }
      this.closeInsertAndUpdate();
    },

    deleteItem(item) {
      this.editedIndex = this.tableData.indexOf(item);
      this.editedItem = Object.assign({}, item);
      this.dialogForDelete = true;
    },

    closeDelete() {
      this.dialogForDelete = false;
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultItem);
        this.editedIndex = -1;
      });
    },

    deleteItemConfirm() {
      console.log(this.tableData[this.editedIndex].homeId);
      this.tableLoading = true;
      this.$api.home
        .delete(this.tableData[this.editedIndex].homeId)
        .then(resp => {
          if (resp.data.data === 1) {
            this.tableLoading = false;
            this.snack = true;
            this.snackColor = 'success';
            this.snackText = 'Delete successfully!';
            this.$api.home
              .select({ pageNum: this.pageNum })
              .then(resp => {
                this.tableData = resp.data.data.content;
                this.pageTotal = resp.data.data.pageTotal;
                // console.log(resp);
              })
              .catch(err => {
                console.error(err);
              });
          } else {
            this.tableLoading = false;
            this.snack = true;
            this.snackColor = 'error';
            this.snackText = "Server happened error! Don't delete data!";
          }
        })
        .catch(err => {
          this.tableLoading = false;
          console.log(err);
          this.snack = true;
          this.snackColor = 'error';
          this.snackText = 'Local js happened error!';
        });
      // this.tableData.splice(this.editedIndex, 1);
      this.closeDelete();
    },
  },
};
</script>

<style scoped></style>
