package com.fuxi.bridge.contracts;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.fisco.bcos.channel.client.TransactionSucCallback;
import org.fisco.bcos.channel.event.filter.EventLogPushWithDecodeCallback;
import org.fisco.bcos.web3j.abi.EventEncoder;
import org.fisco.bcos.web3j.abi.FunctionEncoder;
import org.fisco.bcos.web3j.abi.FunctionReturnDecoder;
import org.fisco.bcos.web3j.abi.TypeReference;
import org.fisco.bcos.web3j.abi.datatypes.Address;
import org.fisco.bcos.web3j.abi.datatypes.Bool;
import org.fisco.bcos.web3j.abi.datatypes.Event;
import org.fisco.bcos.web3j.abi.datatypes.Function;
import org.fisco.bcos.web3j.abi.datatypes.Type;
import org.fisco.bcos.web3j.abi.datatypes.Utf8String;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint256;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.RemoteCall;
import org.fisco.bcos.web3j.protocol.core.methods.response.Log;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tuples.generated.Tuple1;
import org.fisco.bcos.web3j.tuples.generated.Tuple2;
import org.fisco.bcos.web3j.tx.Contract;
import org.fisco.bcos.web3j.tx.TransactionManager;
import org.fisco.bcos.web3j.tx.gas.ContractGasProvider;
import org.fisco.bcos.web3j.tx.txdecode.TransactionDecoder;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.fisco.bcos.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version none.
 */
@SuppressWarnings("unchecked")
public class StorageController extends Contract {
    public static final String[] BINARY_ARRAY = {"608060405234801561001057600080fd5b506040516020806126b28339810180604052810190808051906020019092919050505080336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555080600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050506125ec806100c66000396000f3006080604052600436106100a4576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806313af4035146100a9578063196aee90146100ec578063775d5e011461012f57806384339c7c146102575780638d8557a81461029a5780639c99c89c14610349578063b2bdfa7b146103d2578063be83506614610429578063e5444a4214610480578063f00eb9b5146104d7575b600080fd5b3480156100b557600080fd5b506100ea600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061050e565b005b3480156100f857600080fd5b5061012d600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610693565b005b34801561013b57600080fd5b506101dc600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050610b7c565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561021c578082015181840152602081019050610201565b50505050905090810190601f1680156102495780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561026357600080fd5b50610298600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061101c565b005b3480156102a657600080fd5b50610347600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091929192905050506111a2565b005b34801561035557600080fd5b506103d0600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050611808565b005b3480156103de57600080fd5b506103e7611b42565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561043557600080fd5b5061043e611b67565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561048c57600080fd5b506104c1600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050611b8d565b6040518082815260200191505060405180910390f35b3480156104e357600080fd5b5061050c6004803603810190808035906020019092919080359060200190929190505050611cca565b005b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614806105b65750600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16145b1515610650576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260308152602001807f4261736963417574683a6f6e6c79206f776e6572206f722062616b206f776e6581526020017f7220697320617574686f72697a6564210000000000000000000000000000000081525060400191505060405180910390fd5b806000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16148061073d5750600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16145b15156107d7576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260308152602001807f4261736963417574683a6f6e6c79206f776e6572206f722062616b206f776e6581526020017f7220697320617574686f72697a6564210000000000000000000000000000000081525060400191505060405180910390fd5b600073ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff161415151561087c576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260208152602001807f4163636f756e7420616464726573732063616e206e6f74206265206e756c6c2181525060200191505060405180910390fd5b600460405180807f53636f72654442000000000000000000000000000000000000000000000000008152506007019050908152602001604051809103902060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663889a37c6836040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b15801561097557600080fd5b505af1158015610989573d6000803e3d6000fd5b505050506040513d602081101561099f57600080fd5b810190808051906020019092919050505090508015610a9a577f27db5840a3323b701d3764ea00aed345a1ff91538216dda1ee283eaf0de1022e33836001604051808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200180602001828103825260118152602001807f526567697374657220737563636573732100000000000000000000000000000081525060200194505050505060405180910390a1610b78565b7f27db5840a3323b701d3764ea00aed345a1ff91538216dda1ee283eaf0de1022e33836000604051808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182151515158152602001806020018281038252600e8152602001807f5265676973746572206661696c2100000000000000000000000000000000000081525060200194505050505060405180910390a15b5050565b606060006060610b8b84611ed7565b91508173ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610d1257600460405180807f53636f72654442000000000000000000000000000000000000000000000000008152506007019050908152602001604051809103902060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166326530f3983336003546040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019350505050600060405180830381600087803b158015610cf957600080fd5b505af1158015610d0d573d6000803e3d6000fd5b505050505b600460405180807f53746f72616765444200000000000000000000000000000000000000000000008152506009019050908152602001604051809103902060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663553a190c86866040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808060200180602001838103835285818151815260200191508051906020019080838360005b83811015610dfd578082015181840152602081019050610de2565b50505050905090810190601f168015610e2a5780820380516001836020036101000a031916815260200191505b50838103825284818151815260200191508051906020019080838360005b83811015610e63578082015181840152602081019050610e48565b50505050905090810190601f168015610e905780820380516001836020036101000a031916815260200191505b50945050505050600060405180830381600087803b158015610eb157600080fd5b505af1158015610ec5573d6000803e3d6000fd5b505050506040513d6000823e3d601f19601f820116820180604052506020811015610eef57600080fd5b810190808051640100000000811115610f0757600080fd5b82810190506020810184811115610f1d57600080fd5b8151856001820283011164010000000082111715610f3a57600080fd","5b505092919050505090508173ffffffffffffffffffffffffffffffffffffffff16856040518082805190602001908083835b602083101515610f915780518252602082019150602081019050602083039250610f6c565b6001836020036101000a03801982511681845116808217855250505050505090500191505060405180910390203373ffffffffffffffffffffffffffffffffffffffff167f5b75e3354acc46c5a47aaab88128a39f8b355f429e41cacbf3b7c15d996256676001604051808215151515815260200191505060405180910390a4809250505092915050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614806110c45750600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16145b151561115e576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260308152602001807f4261736963417574683a6f6e6c79206f776e6572206f722062616b206f776e6581526020017f7220697320617574686f72697a6564210000000000000000000000000000000081525060400191505060405180910390fd5b80600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b600080606060006111b233612282565b9150600460405180807f53746f72616765444200000000000000000000000000000000000000000000008152506009019050908152602001604051809103902060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663da465d748787856040518463ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180806020018060200180602001848103845287818151815260200191508051906020019080838360005b838110156112a4578082015181840152602081019050611289565b50505050905090810190601f1680156112d15780820380516001836020036101000a031916815260200191505b50848103835286818151815260200191508051906020019080838360005b8381101561130a5780820151818401526020810190506112ef565b50505050905090810190601f1680156113375780820380516001836020036101000a031916815260200191505b50848103825285818151815260200191508051906020019080838360005b83811015611370578082015181840152602081019050611355565b50505050905090810190601f16801561139d5780820380516001836020036101000a031916815260200191505b5096505050505050506040805180830381600087803b1580156113bf57600080fd5b505af11580156113d3573d6000803e3d6000fd5b505050506040513d60408110156113e957600080fd5b81019080805190602001909291908051906020019092919050505080945081955050506000905060008413156118005782156116b957600460405180807f53636f72654442000000000000000000000000000000000000000000000000008152506007019050908152602001604051809103902060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16631a7231ec336002546040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050602060405180830381600087803b15801561152257600080fd5b505af1158015611536573d6000803e3d6000fd5b505050506040513d602081101561154c57600080fd5b8101908080519060200190929190505050905080156116af57846040518082805190602001908083835b60208310151561159b5780518252602082019150602081019050602083039250611576565b6001836020036101000a0380198251168184511680821785525050505050509050019150506040518091039020866040518082805190602001908083835b6020831015156115fe57805182526020820191506020810190506020830392506115d9565b6001836020036101000a03801982511681845116808217855250505050505090500191505060405180910390203373ffffffffffffffffffffffffffffffffffffffff167fca17466a910a873d55e3198790de2ede604916e5fb85c05a6d3da122648a0b5660405180806020018281038252601a8152602001807f53746f726520737563636573732c61646420737563636573732100000000000081525060200191505060405180910390a46116b4565b600080fd5b6117ff565b846040518082805190602001908083835b6020831015156116ef57805182526020820191506020810190506020830392506116ca565b6001836020036101000a0380198251168184511680821785525050505050509050019150506040518091039020866040518082805190602001908083835b602083101515611752578051825260208201915060208101905060208303925061172d565b6001836020036101000a03801982511681845116808217855250505050505090500191505060405180910390203373ffffffffffffffffffffffffffffffffffffffff167fca17466a910a873d55e3198790de2ede604916e5fb85c05a6d3da122648a0b5660405180806020018281038252600f8152602001807f4d6f64696679207375636365737321000000000000000000000000000000000081525060200191505060405180910390a45b5b505050505050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614806118b05750600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16145b151561194a576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260308152602001807f4261736963417574683a6f6e6c79206f776e6572206f722062616b206f776e6581526020017f7220697320617574686f72697a6564210000000000000000000000000000000081525060400191505060405180910390fd5b806004836040518082805190602001908083835b602083101515611983578051825260208201915060208101905060208303925061195e565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055507fc4ae7cec4198f2c25b32e5a29aba0a8e14377757ab53034eb7c4eab12900919f3383836001604051808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001806020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018315151515815260200180602001838103835286818151815260200191508051906020019080838360005b83811015611acc578082015181840152602081019050611ab1565b50505050905090810190601f168015611af95780820380516001836020036101000a031916815260200191505b508381038252601d8152602001807f53657420636f6e74726163742061646472657373207375636365737321000000815250602001965050505050505060405180910390a15050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6000600460405180807f53636f72654442000000000000000000000000000000000000000000000000008152506007019050908152602001604051809103902060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663e5444a42836040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b158015611c8857600080fd5b505af1158015611c9c573d6000803e3d6000fd5b505050506040513d6020811015611cb257600080fd5b81019080805190602001909291905050509050919050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161480611d725750600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16145b1515611e0c576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260308152602001807f4261736963417574683a6f6e6c79206f776e6572206f722062616b206f776e6581526020017f7220697320617574686f72697a6564210000000000000000000000000000000081525060400191505060405180910390fd5b81600281905550806003819055507fc62ac4d9bfa39fc8f62e3df91fc88b81fea505c488c75d79ce79e0d15f0a571c3383836001604051808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200184815260200183815260200182151515158152602001806020018281038252601b8152602001807f5365742073636f72652073657474696e677320737563636573732100000000008152506020019550505050505060405180910390a15050565b600060606000806000806000806000808a98506027895110158015611efe5750602a895111155b1515611f72576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252600e","8152602001807f4e6f742068657820737472696e6700000000000000000000000000000000000081525060200191505060405180910390fd5b60009750600096507f7800000000000000000000000000000000000000000000000000000000000000896001815181101515611faa57fe5b9060200101517f010000000000000000000000000000000000000000000000000000000000000090047f0100000000000000000000000000000000000000000000000000000000000000027effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff191614806120bd57507f580000000000000000000000000000000000000000000000000000000000000089600181518110151561204e57fe5b9060200101517f010000000000000000000000000000000000000000000000000000000000000090047f0100000000000000000000000000000000000000000000000000000000000000027effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916145b156120c757600297505b600095508789510394506027851415612151576121418989806001019a508151811015156120f157fe5b9060200101517f010000000000000000000000000000000000000000000000000000000000000090047f0100000000000000000000000000000000000000000000000000000000000000026124c1565b60ff168601955086806001019750505b8693505b60148410156122715760088673ffffffffffffffffffffffffffffffffffffffff169060020a0295506121df898981518110151561218f57fe5b9060200101517f010000000000000000000000000000000000000000000000000000000000000090047f0100000000000000000000000000000000000000000000000000000000000000026124c1565b92506122458960018a018151811015156121f557fe5b9060200101517f010000000000000000000000000000000000000000000000000000000000000090047f0100000000000000000000000000000000000000000000000000000000000000026124c1565b91508160048460ff169060020a020190508060ff16860195506002880197508380600101945050612155565b859950505050505050505050919050565b606060006060600080856c01000000000000000000000000029350602a6040519080825280601f01601f1916602001820160405280156122d15781602001602082028038833980820191505090505b5092507f300000000000000000000000000000000000000000000000000000000000000083600081518110151561230457fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a9053507f780000000000000000000000000000000000000000000000000000000000000083600181518110151561236457fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a905350600091505b60148210156124b55783826014811015156123b057fe5b1a7f0100000000000000000000000000000000000000000000000000000000000000027f01000000000000000000000000000000000000000000000000000000000000009004905061240c60048260ff169060020a9004612547565b836001849060020a0260020181518110151561242457fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a905350612460600f8216612547565b836001849060020a0260030181518110151561247857fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a9053508180600101925050612399565b82945050505050919050565b600080827f01000000000000000000000000000000000000000000000000000000000000009004905060308160ff1610158015612502575060398160ff1611155b1561251257603081039150612541565b60418160ff161015801561252a575060468160ff1611155b1561253a57603781039150612541565b6057810391505b50919050565b6000808260ff1610158015612560575060098260ff1611155b1561259257603082017f01000000000000000000000000000000000000000000000000000000000000000290506125bb565b605782017f01000000000000000000000000000000000000000000000000000000000000000290505b9190505600a165627a7a723058205138126c14d2bc28447be59d54695d1ee379e437e7506c8af475bb61b51634440029"};

    public static final String BINARY = String.join("", BINARY_ARRAY);

    public static final String[] ABI_ARRAY = {"[{\"constant\":false,\"inputs\":[{\"name\":\"owner\",\"type\":\"address\"}],\"name\":\"setOwner\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"customerAddress\",\"type\":\"address\"}],\"name\":\"customerRegister\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"domainHash\",\"type\":\"string\"},{\"name\":\"ownerAddres\",\"type\":\"string\"}],\"name\":\"checkOthersSubmissions\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"owner\",\"type\":\"address\"}],\"name\":\"setBakOwner\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"domainHash\",\"type\":\"string\"},{\"name\":\"contentHash\",\"type\":\"string\"}],\"name\":\"storeInfomation\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"contractName\",\"type\":\"string\"},{\"name\":\"contractAddr\",\"type\":\"address\"}],\"name\":\"setContractMap\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"_owner\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"_bakOwner\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"adder\",\"type\":\"address\"}],\"name\":\"getMyScore\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"store\",\"type\":\"uint256\"},{\"name\":\"exchange\",\"type\":\"uint256\"}],\"name\":\"setScoreSetting\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"inputs\":[{\"name\":\"bakOwner\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"operator\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"store\",\"type\":\"uint256\"},{\"indexed\":false,\"name\":\"exchange\",\"type\":\"uint256\"},{\"indexed\":false,\"name\":\"isSuccess\",\"type\":\"bool\"},{\"indexed\":false,\"name\":\"message\",\"type\":\"string\"}],\"name\":\"_SetScoreSetting\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"operator\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"contractName\",\"type\":\"string\"},{\"indexed\":false,\"name\":\"contractAddr\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"isSuccess\",\"type\":\"bool\"},{\"indexed\":false,\"name\":\"message\",\"type\":\"string\"}],\"name\":\"_SetContractMap\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":true,\"name\":\"operator\",\"type\":\"address\"},{\"indexed\":true,\"name\":\"domainHash\",\"type\":\"string\"},{\"indexed\":true,\"name\":\"contentHash\",\"type\":\"string\"},{\"indexed\":false,\"name\":\"message\",\"type\":\"string\"}],\"name\":\"_StoreInfomation\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":true,\"name\":\"checker\",\"type\":\"address\"},{\"indexed\":true,\"name\":\"domainHash\",\"type\":\"string\"},{\"indexed\":true,\"name\":\"dst\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"isSuccess\",\"type\":\"bool\"}],\"name\":\"_CheckOthersSubmissions\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"operator\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"customerAddress\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"isSuccess\",\"type\":\"bool\"},{\"indexed\":false,\"name\":\"message\",\"type\":\"string\"}],\"name\":\"_CustomerRegister\",\"type\":\"event\"}]"};

    public static final String ABI = String.join("", ABI_ARRAY);

    public static final TransactionDecoder transactionDecoder = new TransactionDecoder(ABI, BINARY);

    public static final String FUNC_SETOWNER = "setOwner";

    public static final String FUNC_CUSTOMERREGISTER = "customerRegister";

    public static final String FUNC_CHECKOTHERSSUBMISSIONS = "checkOthersSubmissions";

    public static final String FUNC_SETBAKOWNER = "setBakOwner";

    public static final String FUNC_STOREINFOMATION = "storeInfomation";

    public static final String FUNC_SETCONTRACTMAP = "setContractMap";

    public static final String FUNC__OWNER = "_owner";

    public static final String FUNC__BAKOWNER = "_bakOwner";

    public static final String FUNC_GETMYSCORE = "getMyScore";

    public static final String FUNC_SETSCORESETTING = "setScoreSetting";

    public static final Event _SETSCORESETTING_EVENT = new Event("_SetScoreSetting", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}));
    ;

    public static final Event _SETCONTRACTMAP_EVENT = new Event("_SetContractMap", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Address>() {}, new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}));
    ;

    public static final Event _STOREINFOMATION_EVENT = new Event("_StoreInfomation", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Utf8String>(true) {}, new TypeReference<Utf8String>(true) {}, new TypeReference<Utf8String>() {}));
    ;

    public static final Event _CHECKOTHERSSUBMISSIONS_EVENT = new Event("_CheckOthersSubmissions", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Utf8String>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Bool>() {}));
    ;

    public static final Event _CUSTOMERREGISTER_EVENT = new Event("_CustomerRegister", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}));
    ;

    @Deprecated
    protected StorageController(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected StorageController(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected StorageController(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected StorageController(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static TransactionDecoder getTransactionDecoder() {
        return transactionDecoder;
    }

    public RemoteCall<TransactionReceipt> setOwner(String owner) {
        final Function function = new Function(
                FUNC_SETOWNER, 
                Arrays.<Type>asList(new Address(owner)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setOwner(String owner, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETOWNER, 
                Arrays.<Type>asList(new Address(owner)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setOwnerSeq(String owner) {
        final Function function = new Function(
                FUNC_SETOWNER, 
                Arrays.<Type>asList(new Address(owner)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<String> getSetOwnerInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETOWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> customerRegister(String customerAddress) {
        final Function function = new Function(
                FUNC_CUSTOMERREGISTER, 
                Arrays.<Type>asList(new Address(customerAddress)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void customerRegister(String customerAddress, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_CUSTOMERREGISTER, 
                Arrays.<Type>asList(new Address(customerAddress)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String customerRegisterSeq(String customerAddress) {
        final Function function = new Function(
                FUNC_CUSTOMERREGISTER, 
                Arrays.<Type>asList(new Address(customerAddress)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<String> getCustomerRegisterInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_CUSTOMERREGISTER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> checkOthersSubmissions(String domainHash, String ownerAddres) {
        final Function function = new Function(
                FUNC_CHECKOTHERSSUBMISSIONS, 
                Arrays.<Type>asList(new Utf8String(domainHash),
                new Utf8String(ownerAddres)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void checkOthersSubmissions(String domainHash, String ownerAddres, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_CHECKOTHERSSUBMISSIONS, 
                Arrays.<Type>asList(new Utf8String(domainHash),
                new Utf8String(ownerAddres)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String checkOthersSubmissionsSeq(String domainHash, String ownerAddres) {
        final Function function = new Function(
                FUNC_CHECKOTHERSSUBMISSIONS, 
                Arrays.<Type>asList(new Utf8String(domainHash),
                new Utf8String(ownerAddres)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<String, String> getCheckOthersSubmissionsInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_CHECKOTHERSSUBMISSIONS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<String, String>(

                (String) results.get(0).getValue(), 
                (String) results.get(1).getValue()
                );
    }

    public Tuple1<String> getCheckOthersSubmissionsOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_CHECKOTHERSSUBMISSIONS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> setBakOwner(String owner) {
        final Function function = new Function(
                FUNC_SETBAKOWNER, 
                Arrays.<Type>asList(new Address(owner)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setBakOwner(String owner, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETBAKOWNER, 
                Arrays.<Type>asList(new Address(owner)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setBakOwnerSeq(String owner) {
        final Function function = new Function(
                FUNC_SETBAKOWNER, 
                Arrays.<Type>asList(new Address(owner)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<String> getSetBakOwnerInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETBAKOWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> storeInfomation(String domainHash, String contentHash) {
        final Function function = new Function(
                FUNC_STOREINFOMATION, 
                Arrays.<Type>asList(new Utf8String(domainHash),
                new Utf8String(contentHash)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void storeInfomation(String domainHash, String contentHash, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_STOREINFOMATION, 
                Arrays.<Type>asList(new Utf8String(domainHash),
                new Utf8String(contentHash)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String storeInfomationSeq(String domainHash, String contentHash) {
        final Function function = new Function(
                FUNC_STOREINFOMATION, 
                Arrays.<Type>asList(new Utf8String(domainHash),
                new Utf8String(contentHash)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<String, String> getStoreInfomationInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_STOREINFOMATION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<String, String>(

                (String) results.get(0).getValue(), 
                (String) results.get(1).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> setContractMap(String contractName, String contractAddr) {
        final Function function = new Function(
                FUNC_SETCONTRACTMAP, 
                Arrays.<Type>asList(new Utf8String(contractName),
                new Address(contractAddr)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setContractMap(String contractName, String contractAddr, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETCONTRACTMAP, 
                Arrays.<Type>asList(new Utf8String(contractName),
                new Address(contractAddr)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setContractMapSeq(String contractName, String contractAddr) {
        final Function function = new Function(
                FUNC_SETCONTRACTMAP, 
                Arrays.<Type>asList(new Utf8String(contractName),
                new Address(contractAddr)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<String, String> getSetContractMapInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETCONTRACTMAP, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<String, String>(

                (String) results.get(0).getValue(), 
                (String) results.get(1).getValue()
                );
    }

    public RemoteCall<String> _owner() {
        final Function function = new Function(FUNC__OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> _bakOwner() {
        final Function function = new Function(FUNC__BAKOWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> getMyScore(String adder) {
        final Function function = new Function(
                FUNC_GETMYSCORE, 
                Arrays.<Type>asList(new Address(adder)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void getMyScore(String adder, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_GETMYSCORE, 
                Arrays.<Type>asList(new Address(adder)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String getMyScoreSeq(String adder) {
        final Function function = new Function(
                FUNC_GETMYSCORE, 
                Arrays.<Type>asList(new Address(adder)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<String> getGetMyScoreInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_GETMYSCORE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
    }

    public Tuple1<BigInteger> getGetMyScoreOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_GETMYSCORE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> setScoreSetting(BigInteger store, BigInteger exchange) {
        final Function function = new Function(
                FUNC_SETSCORESETTING, 
                Arrays.<Type>asList(new Uint256(store),
                new Uint256(exchange)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setScoreSetting(BigInteger store, BigInteger exchange, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETSCORESETTING, 
                Arrays.<Type>asList(new Uint256(store),
                new Uint256(exchange)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setScoreSettingSeq(BigInteger store, BigInteger exchange) {
        final Function function = new Function(
                FUNC_SETSCORESETTING, 
                Arrays.<Type>asList(new Uint256(store),
                new Uint256(exchange)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<BigInteger, BigInteger> getSetScoreSettingInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETSCORESETTING, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<BigInteger, BigInteger>(

                (BigInteger) results.get(0).getValue(), 
                (BigInteger) results.get(1).getValue()
                );
    }

    public List<_SetScoreSettingEventResponse> get_SetScoreSettingEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(_SETSCORESETTING_EVENT, transactionReceipt);
        ArrayList<_SetScoreSettingEventResponse> responses = new ArrayList<_SetScoreSettingEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            _SetScoreSettingEventResponse typedResponse = new _SetScoreSettingEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.operator = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.store = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.exchange = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.isSuccess = (Boolean) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.message = (String) eventValues.getNonIndexedValues().get(4).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void register_SetScoreSettingEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(_SETSCORESETTING_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void register_SetScoreSettingEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(_SETSCORESETTING_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
    }

    public List<_SetContractMapEventResponse> get_SetContractMapEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(_SETCONTRACTMAP_EVENT, transactionReceipt);
        ArrayList<_SetContractMapEventResponse> responses = new ArrayList<_SetContractMapEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            _SetContractMapEventResponse typedResponse = new _SetContractMapEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.operator = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.contractName = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.contractAddr = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.isSuccess = (Boolean) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.message = (String) eventValues.getNonIndexedValues().get(4).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void register_SetContractMapEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(_SETCONTRACTMAP_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void register_SetContractMapEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(_SETCONTRACTMAP_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
    }

    public List<_StoreInfomationEventResponse> get_StoreInfomationEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(_STOREINFOMATION_EVENT, transactionReceipt);
        ArrayList<_StoreInfomationEventResponse> responses = new ArrayList<_StoreInfomationEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            _StoreInfomationEventResponse typedResponse = new _StoreInfomationEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.operator = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.domainHash = (byte[]) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.contentHash = (byte[]) eventValues.getIndexedValues().get(2).getValue();
            typedResponse.message = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void register_StoreInfomationEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(_STOREINFOMATION_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void register_StoreInfomationEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(_STOREINFOMATION_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
    }

    public List<_CheckOthersSubmissionsEventResponse> get_CheckOthersSubmissionsEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(_CHECKOTHERSSUBMISSIONS_EVENT, transactionReceipt);
        ArrayList<_CheckOthersSubmissionsEventResponse> responses = new ArrayList<_CheckOthersSubmissionsEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            _CheckOthersSubmissionsEventResponse typedResponse = new _CheckOthersSubmissionsEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.checker = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.domainHash = (byte[]) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.dst = (String) eventValues.getIndexedValues().get(2).getValue();
            typedResponse.isSuccess = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void register_CheckOthersSubmissionsEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(_CHECKOTHERSSUBMISSIONS_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void register_CheckOthersSubmissionsEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(_CHECKOTHERSSUBMISSIONS_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
    }

    public List<_CustomerRegisterEventResponse> get_CustomerRegisterEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(_CUSTOMERREGISTER_EVENT, transactionReceipt);
        ArrayList<_CustomerRegisterEventResponse> responses = new ArrayList<_CustomerRegisterEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            _CustomerRegisterEventResponse typedResponse = new _CustomerRegisterEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.operator = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.customerAddress = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.isSuccess = (Boolean) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.message = (String) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void register_CustomerRegisterEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(_CUSTOMERREGISTER_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void register_CustomerRegisterEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(_CUSTOMERREGISTER_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
    }

    @Deprecated
    public static StorageController load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new StorageController(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static StorageController load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new StorageController(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static StorageController load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new StorageController(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static StorageController load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new StorageController(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<StorageController> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String bakOwner) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(bakOwner)));
        return deployRemoteCall(StorageController.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<StorageController> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String bakOwner) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(bakOwner)));
        return deployRemoteCall(StorageController.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<StorageController> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String bakOwner) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(bakOwner)));
        return deployRemoteCall(StorageController.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<StorageController> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String bakOwner) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(bakOwner)));
        return deployRemoteCall(StorageController.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class _SetScoreSettingEventResponse {
        public Log log;

        public String operator;

        public BigInteger store;

        public BigInteger exchange;

        public Boolean isSuccess;

        public String message;
    }

    public static class _SetContractMapEventResponse {
        public Log log;

        public String operator;

        public String contractName;

        public String contractAddr;

        public Boolean isSuccess;

        public String message;
    }

    public static class _StoreInfomationEventResponse {
        public Log log;

        public String operator;

        public byte[] domainHash;

        public byte[] contentHash;

        public String message;
    }

    public static class _CheckOthersSubmissionsEventResponse {
        public Log log;

        public String checker;

        public byte[] domainHash;

        public String dst;

        public Boolean isSuccess;
    }

    public static class _CustomerRegisterEventResponse {
        public Log log;

        public String operator;

        public String customerAddress;

        public Boolean isSuccess;

        public String message;
    }
}
