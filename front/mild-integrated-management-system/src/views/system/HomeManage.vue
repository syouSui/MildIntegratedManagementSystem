<template>
  <v-container fluid app class="my-6">
    <p>HomeManage</p>
    <v-row>
      <v-col> <p>Btn area</p> </v-col>
    </v-row>
    <v-row>
      <v-col justify="center" align="center">
        <v-data-table
          :headers="headers"
          :items="tableData"
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
  }),

  computed: {
    formTitle() {
      return this.editedIndex === -1 ? '新建项' : '编辑项';
    },
  },

  watch: {
    dialogForInsertAndUpdate(val) {
      val || this.closeInsertAndUpdate();
    },
    dialogForDelete(val) {
      val || this.closeDelete();
    },
    pageNum(val) {
      // console.log(val);
      this.$api.home
        .select({ pageNum: val })
        .then(resp => {
          this.tableData = resp.data.data.content;
          this.pageTotal = resp.data.data.pageTotal;
          // console.log(resp);
        })
        .catch(err => {
          console.error(err);
        });
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
        this.$api.home
          .update(obj)
          .then(resp => {
            if (resp.data.data === 1) {
              console.log('Modify successfully');
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
              console.log("Server happened error! Don't update data!");
            }
          })
          .catch(err => {
            console.log('Local js happened error!');
            console.log(err);
          });
      } else {
        // Insert Item
        this.$api.home
          .insert(obj)
          .then(resp => {
            if (resp.data.data === 1) {
              console.log('insert successfully');
              this.$api.home
                .select({ pageNum: this.pageNum })
                .then(resp => {
                  this.tableData = resp.data.data.content;
                  this.pageTotal = resp.data.data.pageTotal;
                })
                .catch(err => {
                  console.log(err);
                  //
                });
            } else {
              // console.log(resp);
              console.log("Server happened error! Don't insert data!");
            }
          })
          .catch(err => {
            console.log('Local js happened error!');
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
      this.$api.home
        .delete(this.tableData[this.editedIndex].homeId)
        .then(resp => {
          if (resp.data.data === 1) {
            console.log('delete successfully');
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
            console.log("Server happened error! Don't delete data!");
          }
        })
        .catch(err => {
          console.log('Local js happened error!');
          console.log(err);
        });
      // this.tableData.splice(this.editedIndex, 1);
      this.closeDelete();
    },
  },
};
</script>

<style scoped></style>
