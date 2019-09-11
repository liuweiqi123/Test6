import React from 'react';
import 'antd/dist/antd.css';
import { Alert,Form, Icon, Input, Button, Checkbox } from 'antd';
import Axios from 'axios';
class NormalLoginForm extends React.Component {
  handleSubmit = e => {
    e.preventDefault();
    this.props.form.validateFields((err, values) => {
      if (!err) {
        console.log('Received values of form: ', values);
      }
    });
  };
  Login=(e)=>{
        var value;
        this.props.form.validateFieldsAndScroll(
          (err, values) => {
          if (!err) {
            value = values;
          }
        });
        var data={
          username:value.username,
          password:value.password,
        }
        let history = this.props.history;
        Axios({
            method: 'post',
            url: 'http://localhost:8080/login',
            params: data
          }).then(function(response){  
            if(response.data=="success"){
                console.log(response);
                alert("登录成功");
                history.push('/UserInfo');
            }
            else{
              <Button onClick={() => openNotificationWithIcon('error')}>Error</Button>
              console.log("用户名或密码错误")
              console.log(response)
              alert("用户名或密码错误")
            }
            
          }).catch(function(error){
              console.log(error);

          });
      }
  render() {
    const { getFieldDecorator } = this.props.form;
    return (
      <div id="login">
      <Form onSubmit={this.handleSubmit} className="login-form" style={{margin:'250px'}}>
        <Form.Item>
          {getFieldDecorator('username', {
            rules: [{ required: true, message: '请输入用户名！' }],
          })(
            <Input
              prefix={<Icon type="user" style={{ color: 'rgba(0,0,0,.25)' }} />}
              placeholder="用户名"
            />,
          )}
        </Form.Item>
        <Form.Item>
          {getFieldDecorator('password', {
            rules: [{ required: true, message: '请输入密码！' }],
          })(
            <Input
              prefix={<Icon type="lock" style={{ color: 'rgba(0,0,0,.25)' }} />}
              type="password"
              placeholder="密码"
            />,
          )}
        </Form.Item>
        <Form.Item>
          {getFieldDecorator('remember', {
            valuePropName: 'checked',
            initialValue: true,
          })(<Checkbox>Remember me</Checkbox>)}
          <Button type="primary" htmlType="submit" className="login-form-button" onClick={this.Login}>
            登录
          </Button>
        </Form.Item>
      </Form>
      </div>
    );
  }
}

const Login = Form.create({ name: 'normal_login' })(NormalLoginForm);


export default Login;