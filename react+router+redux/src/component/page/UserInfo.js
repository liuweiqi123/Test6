
import { Table,Button,Input,Icon,Popconfirm,Alert,Modal } from 'antd';
import React,{Component} from 'react';
import Axios from 'axios';
import { Link } from "react-router-dom";

class UserInfo extends Component {
    constructor(props){
        super(props);
        this.state = {
         ModalText: 'Content of the modal',
         visible: false,
         visibleEdit:false,
         confirmLoading: false,
            dataSource: [],
            columns :[
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
            ]
        }
    }

    confirm = () =>{
      this.props.history.push('/Find')
    }
//当组件输出到 DOM 后会执行 componentDidMount()
componentDidMount(){
    const _this=this;    //先存一下this，以防使用箭头函数this会指向我们不希望它所指向的对象。
    Axios.post('http://localhost:8080/userInfo')
    .then(function (response) {
      console.log(response.data)
      _this.setState({
        dataSource:response.data,
        isLoaded:true
      });
    })
    .catch(function (error) {
      console.log(error);
      _this.setState({
        isLoaded:false,
        error:error
      })
    })
  }
    render(){     
      return (
        <div>
          <Button type="primary" onClick={this.confirm}>查找</Button>
            <Table dataSource={this.state.dataSource}  columns={this.state.columns} size="middle" />
        </div>
        
    )
    }
}

export default UserInfo;