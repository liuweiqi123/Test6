import  React,{Component} from 'react';

import UserInfo from './page/UserInfo';
import TransLation from './page/TransLation';
import HeadLine from './page/HeadLine';
import Login from './page/login';
import Weather from './page/Weather';
import Find from './page/Find'
import {HashRouter,Switch,Route,Link} from 'react-router-dom';
import { Layout, Menu, Icon } from 'antd';

const { Header, Content,  Sider } = Layout;
class App extends Component{
  state = {
    collapsed: false,
  };
  toggle =()=> {
    this.setState({
      collapsed: !this.state.collapsed,
    });
  };
  render(){
    return <HashRouter>
      <Switch>
            <Route exact path="/"  component={Login}></Route>
            <Layout>
              <Sider trigger={null} collapsible collapsed={this.state.collapsed}>
                  <div className="title">
                      <p>后台管理</p>
                  </div>
                  <Menu theme="dark" mode="inline" defaultSelectedKeys={["1"]}>
                    <Menu.Item key="1">
                      <Icon type="ant-cloud" />
                      <span>天气预报</span>
                      <Link to="/Weather"></Link>
                    </Menu.Item>
                    <Menu.Item key="2">
                      <Icon type="book" />
                      <span>头条新闻</span>
                      <Link to="/HeadLine"></Link>
                    </Menu.Item>
                    <Menu.Item key="3">
                      <Icon type="sync" />
                      <span>中英翻译</span>
                      <Link to="/TransLation"></Link>
                    </Menu.Item>
                    <Menu.Item key="4">
                      <Icon type="search" />
                      <span>员工信息</span>
                      <Link to="/UserInfo"></Link>
                    </Menu.Item>
                </Menu>
              </Sider>
              <Layout>
                <Header className="header" style={{background: '#fff'}}>
                  <Icon className="trigger" type={this.state.collapsed ? 'menu-unfold' : 'menu-fold'} onClick={this.toggle} />
                  </Header>
                  <Content  style={{ margin: '24px 16px',padding: 24,background: '#fff',minHeight: 700}}>
                      <Route path="/Weather"  component={Weather}></Route>
                      <Route path="/HeadLine"  component={HeadLine}></Route>
                      <Route path="/TransLation"  component={TransLation}></Route>
                      <Route path="/UserInfo"  component={UserInfo}></Route>
                      <Route path="/Find"  component={Find}></Route>
                  </Content>
              </Layout>
            </Layout>
            </Switch>
        </HashRouter>
    }
}
export default App;