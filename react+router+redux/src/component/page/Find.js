import React, { Component } from "react";
import axios from "axios";
import { Button, Input, Table, Card } from "antd";
import qs from 'qs';
class Find extends Component {
  constructor(props) {
    super(props);
    this.state = {
      lists: []
    };
    this.GetData = this.GetData.bind(this);
  }


  GetData() {
    var usercode = document.getElementById("usercode").value;
    //alert(usercode)
    let params=qs.stringify({
        usercode:usercode,
    });
    axios.post("http://localhost:8080/quartz/userselect",params).then(res => {
      console.log(res);
      console.log(res.data);
      this.setState({
        lists: [res.data]
      });
      console.log(this.state.lists);
    });
    console.log(this.state.lists);
  }
  render() {
    const columns = [
        {
            title: '员工编号',
            dataIndex: 'usercode',
            key: 'usercode',
          },
          {
            title: '姓名',
            dataIndex: 'username',
            key: 'username',
          },
          {
            title: '部门',
            dataIndex: 'dpartmentCode',
            key: 'dpartmentCode',
          },
          {
            title: '所在职位',
            dataIndex: 'stationCode',
            key: 'stationCode',
          },
          {
            title: '创建时间',
            dataIndex: 'createTime',
            key: 'createTime',
          },  
    ];

    return (
      <div>
        <Card title={"员工查询"}>
          <Input
            placeholder="请输入员工编号"
            id="usercode"
            style={{
              margin: "10px",
              width: "300px"
            }}
          />

          <Button type="primary" onClick={this.GetData}>
            员工查询
          </Button>

          <Table
            columns={columns}
            dataSource={this.state.lists}
            bordered
            style={{
              height: "250px"
            }}
          />
        </Card>
      </div>
    );
  }
}
export default Find;