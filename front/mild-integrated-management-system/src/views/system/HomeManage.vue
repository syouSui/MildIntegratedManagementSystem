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
              <!--              Dialog for Edit and New-->
              <v-dialog
                v-model="dialogForNewAndEdit"
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
                  <v-card-title>
                    <span class="headline">{{ formTitle }}</span>
                  </v-card-title>
                  <v-card-text>
                    <v-container>
                      <v-row>
                        <v-col cols="12" sm="6" md="6" lg="6">
                          <v-text-field
                            v-model="editedItem.home_id"
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
                            v-model="editedItem.updated_time"
                            label="Updated Time"
                            readonly
                            disabled
                          ></v-text-field>
                        </v-col>
                        <v-col cols="12" sm="6" md="6" lg="6">
                          <v-select
                            v-model="editedItem.home_type_id"
                            :items="selectItems"
                            label="Home Type"
                          ></v-select>
                        </v-col>
                      </v-row>
                    </v-container>
                  </v-card-text>

                  <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn color="blue darken-1" text @click="close">
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
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: 'HomeManage',

  data: () => ({
    name: '房屋信息一览表',
    dialogForNewAndEdit: false,
    dialogForDelete: false,
    headers: [
      { text: 'ID', align: 'start', value: 'home_id' },
      { text: '标题', value: 'title' },
      { text: '价格', value: 'price' },
      { text: '更新时间', value: 'updated_time' },
      { text: '房屋类型', value: 'home_type_id' },
      { text: '编辑项', value: 'actions', sortable: false },
    ],
    tableData: [],
    editedIndex: -1,
    editedItem: {
      home_id: '',
      title: 0,
      price: 0,
      updated_time: 0,
      home_type_id: 0,
    },
    defaultItem: {
      home_id: '',
      title: 0,
      price: 0,
      updated_time: 0,
      home_type_id: 0,
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
  }),

  computed: {
    formTitle() {
      return this.editedIndex === -1 ? '新建项' : '编辑项';
    },
  },

  watch: {
    dialogForNewAndEdit(val) {
      val || this.close();
    },
    dialogForDelete(val) {
      val || this.closeDelete();
    },
  },

  created() {
    this.initialize();
    console.log(this.$vuetify.breakpoint.name);
    console.log(this.tableData);
  },

  methods: {
    initialize() {
      this.tableData = [
        {
          home_id: 'Frozen Yogurt',
          title: 159,
          price: 6.0,
          updated_time: 24,
          home_type_id: '一室一厅一卫',
        },
        {
          home_id: 'Ice cream sandwich',
          title: 237,
          price: 9.0,
          updated_time: 37,
          home_type_id: 4.3,
        },
        {
          home_id: 'Eclair',
          title: 262,
          price: 16.0,
          updated_time: 23,
          home_type_id: 6.0,
        },
        {
          home_id: 'Cupcake',
          title: 305,
          price: 3.7,
          updated_time: 67,
          home_type_id: 4.3,
        },
        {
          home_id: 'Gingerbread',
          title: 356,
          price: 16.0,
          updated_time: 49,
          home_type_id: 3.9,
        },
        {
          home_id: 'Jelly bean',
          title: 375,
          price: 0.0,
          updated_time: 94,
          home_type_id: 0.0,
        },
        {
          home_id: 'Lollipop',
          title: 392,
          price: 0.2,
          updated_time: 98,
          home_type_id: 0,
        },
        {
          home_id: 'Honeycomb',
          title: 408,
          price: 3.2,
          updated_time: 87,
          home_type_id: 6.5,
        },
        {
          home_id: 'Donut',
          title: 452,
          price: 25.0,
          updated_time: 51,
          home_type_id: 4.9,
        },
        {
          home_id: 'KitKat',
          title: 518,
          price: 26.0,
          updated_time: 65,
          home_type_id: 7,
        },
      ];
    },

    editItem(item) {
      this.editedIndex = this.tableData.indexOf(item);
      this.editedItem = Object.assign({}, item);
      this.dialogForNewAndEdit = true;
    },

    deleteItem(item) {
      this.editedIndex = this.tableData.indexOf(item);
      this.editedItem = Object.assign({}, item);
      this.dialogForDelete = true;
    },

    deleteItemConfirm() {
      this.tableData.splice(this.editedIndex, 1);
      this.closeDelete();
    },

    close() {
      this.dialogForNewAndEdit = false;
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultItem);
        this.editedIndex = -1;
      });
    },

    closeDelete() {
      this.dialogForDelete = false;
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultItem);
        this.editedIndex = -1;
      });
    },

    save() {
      if (this.editedIndex > -1) {
        Object.assign(this.tableData[this.editedIndex], this.editedItem);
      } else {
        this.tableData.push(this.editedItem);
      }
      this.close();
    },
  },
};
</script>

<style scoped></style>
