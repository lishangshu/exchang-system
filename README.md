## Introduce
This product uses alliance chain technology to realize the exchange of Internet data.This product contains four core services, which are data chain, data classification, domain name information query and incentive mechanism.
1. Data link up: users upload domain name related information, the platform saves the data into the blockchain, and at the same time gives users certain bonus points; the uploaded data includes: resolution record, domain name registration information, domain name server, DNS, etc.
2. Data classification: the uploaded domain name information is divided into open part and confidential part, and points shall be paid when accessing the confidential part.          
3. Domain name information query: other users query domain name information on the platform. When they need to view the confidential part of a domain name, they need to pay certain points to the provider of domain name information.
4. As an external form of incentive mechanism, points can promote users to actively upload domain name data to the platform. At the same time, when viewing domain name data, with the circulation of points, the value of domain name data can be reflected Relationship with blockchain Technology.

## Asymmetric Encryption Technology
The asymmetric encryption technology of blockchain is used to realize data right confirmation, so as to protect the user's rights and interests related to data (ownership, income right, etc.).

## Distributed Storage
By using the distributed storage of blockchain, the data can be linked to the chain, providing users with certificate storage services, and at the same time, the data history can be traced.

## Smart Contract 
Using smart contract to achieve business or transaction automatically and reduce human participation can not only reduce human cost, but also avoid the possibility of business data fraud.

## Project Structure
 This project can be divided into java microservices（contains The registry,[customer-center] user center service,[web-server] front service,[bridge] an intermediate service that connects to a blockchain network），html5 web pages，FISCO-BCOS blockchain and smart contracts，The required components are mysql, Redis and so on。
## Quick Start
1、Deploy the FISCO-BCOS blockchain network，please move to code details -->[FISCO-BCOS](https://github.com/FISCO-BCOS/FISCO-BCOS).ensure the block chain network smooth and consensus，and refer to the FISCO-BCOS official document for details.
2、Instead of trying to keep down what would normally be the cost of deploying a business-related intelligent contract,Please move to the solidity official document -->[Solidity](https://solidity.readthedocs.io/en/latest/)，Generate the corresponding Java smart contract.
3、Compile and package the above Java project, deploy the registry midline first, and then deploy the remaining Java projects in turn.
4、Configure install nginx configure vue code to complete deployment.
## Landing application
- Domain Name Information Exchange System, Access address --> [Exchange System](http://idataexp.fuxitechnology.com)
## Contribute code
- Welcome all the ambitious people to participate, contribute their own strength，please star us!
## License
 All contributions are made under the [GNU General Public License v3](https://www.gnu.org/licenses/gpl-3.0.en.html). See [LICENSE](LICENSE).
