package com.projeto.rastreabilidade.contracts;

import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.5.16.
 */
@SuppressWarnings("rawtypes")
public class Inicializacao extends Contract {
    public static final String BINARY = "600060028181558154336001600160a01b0319918216178084556001600160a01b03166080818152610100604052600560c08181526420b236b4b760d91b60e090815260a09190915260018054808201825597527fb10e2d527612073b26eecdfd717e6a320cf44b4afac2b0732d9fcbe2b7fa0cf696909502958601805490941690921783559391926100b4927fb10e2d527612073b26eecdfd717e6a320cf44b4afac2b0732d9fcbe2b7fa0cf701916100c5565b505060028054600101905550610160565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061010657805160ff1916838001178555610133565b82800160010185558215610133579182015b82811115610133578251825591602001919060010190610118565b5061013f929150610143565b5090565b61015d91905b8082111561013f5760008155600101610149565b90565b6104c08061016f6000396000f3fe608060405234801561001057600080fd5b506004361061004c5760003560e01c80630e232a201461005157806336770c2d146101095780637706558214610161578063b6f44bcd1461017b575b600080fd5b6101076004803603604081101561006757600080fd5b6001600160a01b03823516919081019060408101602082013564010000000081111561009257600080fd5b8201836020820111156100a457600080fd5b803590602001918460018302840111640100000000831117156100c657600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295506101b5945050505050565b005b6101116102b1565b60408051602080825283518183015283519192839290830191858101910280838360005b8381101561014d578181015183820152602001610135565b505050509050019250505060405180910390f35b610169610357565b60408051918252519081900360200190f35b6101a16004803603602081101561019157600080fd5b50356001600160a01b031661035d565b604080519115158252519081900360200190f35b6000546001600160a01b031633146101fe5760405162461bcd60e51b81526004018080602001828103825260338152602001806104586033913960400191505060405180910390fd5b604080518082019091526001600160a01b038381168252602080830184815260018054808201825560009190915284517fb10e2d527612073b26eecdfd717e6a320cf44b4afac2b0732d9fcbe2b7fa0cf6600290920291820180546001600160a01b03191691909516178455905180516102a1937fb10e2d527612073b26eecdfd717e6a320cf44b4afac2b0732d9fcbe2b7fa0cf79093019291909101906103bf565b5050600280546001019055505050565b6060600060606002546040519080825280602002602001820160405280156102e3578160200160208202803683370190505b509050600091505b600254821015610350576001828154811061030257fe5b600091825260209091206002909102015481516001600160a01b039091169082908490811061032d57fe5b6001600160a01b03909216602092830291909101909101526001909101906102eb565b9150505b90565b60025490565b6000805b6002548110156103b457826001600160a01b03166001828154811061038257fe5b60009182526020909120600290910201546001600160a01b031614156103ac5760019150506103ba565b600101610361565b60009150505b919050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061040057805160ff191683800117855561042d565b8280016001018555821561042d579182015b8281111561042d578251825591602001919060010190610412565b5061043992915061043d565b5090565b61035491905b80821115610439576000815560010161044356fe4170656e6173206f2061646d696e6973747261646f7220706f646520657865637574617220657373612066756ec3a7c3a36f2ea26469706673582212206d112d719ab027ba46ba7cf14bb48f757ec4dd3970ea01b27fceef3fb0b3a5f964736f6c63430006040033";

    public static final String FUNC_ADDUSUARIO = "addUsuario";

    public static final String FUNC_QUANTIDADEUSUARIOS = "quantidadeUsuarios";

    public static final String FUNC_RETORNAUSUARIOS = "retornaUsuarios";

    public static final String FUNC_VERIFICARUSUARIO = "verificarUsuario";

    @Deprecated
    protected Inicializacao(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Inicializacao(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Inicializacao(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Inicializacao(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> addUsuario(String usuario, String label) {
        final Function function = new Function(
                FUNC_ADDUSUARIO, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, usuario), 
                new org.web3j.abi.datatypes.Utf8String(label)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> quantidadeUsuarios() {
        final Function function = new Function(FUNC_QUANTIDADEUSUARIOS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<List> retornaUsuarios() {
        final Function function = new Function(FUNC_RETORNAUSUARIOS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<Boolean> verificarUsuario(String usuario) {
        final Function function = new Function(FUNC_VERIFICARUSUARIO, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, usuario)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    @Deprecated
    public static Inicializacao load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Inicializacao(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Inicializacao load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Inicializacao(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Inicializacao load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Inicializacao(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Inicializacao load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Inicializacao(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Inicializacao> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Inicializacao.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<Inicializacao> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Inicializacao.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Inicializacao> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Inicializacao.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Inicializacao> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Inicializacao.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
